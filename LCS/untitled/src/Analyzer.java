import java.util.ArrayList;
import java.util.Arrays;

public class Analyzer {

    int[][] M;
    String s1;
    String s2;

    public int LCS(String s1, String s2) {
        M = new int[s1.length()+1][s2.length()+1];
        Arrays.fill(M, 0);
        this.s1 = s1;
        this.s2 = s2;
        for (int i=0; i<s1.length(); ++i) {
            for (int j=0; j<s2.length(); ++j) {
                opt(i, j);
                traceback(i, j);
            }
        }
        return M[s1.length()][s2.length()];
    }
    private int opt(int i, int j) {
        if (M[i][j] != 0)
            return M[i][j];
        else if (i==0 || j==0)
            return 0;
        else if (s1.charAt(i-1) == s2.charAt(j-1)) {
            M[i][j] = 1 + opt(i-1,j-1);
            return M[i][j];
        }
        else {
            int opt1 = opt(i, j-1);
            int opt2 = opt(i-1, j);

            if (opt1 > opt2) {
                M[i][j] = opt1;
                return M[i][j];
            }
            else {
                M[i][j] = opt2;
                return M[i][j];
            }
        }
    }
    private String traceback(int i, int j) {
        for (int h=0; h<i; ++h) {
            for (int k=0; k<j; ++k) {
                System.out.print(M[h][k]);
            }
            System.out.println("");
        }
        return "String";
    }
}
