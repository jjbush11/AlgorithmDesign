import java.util.ArrayList;
import java.util.Arrays;

public class Analyzer {

    int[][] M;
    String s1;
    String s2;

    public int LCS(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        M = new int[s1.length() + 1][s2.length() + 1];
        int s1Len = s1.length(), s2Len = s2.length();

        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                M[i][j] = 0;
            }
        }

        int numOpt = opt(s1Len, s2Len);
        System.out.println("Optimal solution length: "+numOpt);

        String lcs = traceback(s1Len, s2Len);
        String reversedLcs = "";
        for (int i=lcs.length()-1; i>=0; --i) {
            reversedLcs += lcs.charAt(i);
        }
        System.out.println("Longest Common Subsequence: " + reversedLcs);

        return M[s1.length()][s2.length()];
    }

    private int opt(int i, int j) {
        if (M[i][j] != 0)
            return M[i][j];
        else if (i == 0 || j == 0)
            return 0;
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            M[i][j] = 1 + opt(i - 1, j - 1);
            return M[i][j];
        } else {
            return Math.max(opt(i, j - 1), opt(i - 1, j));
        }
    }

    private String traceback(int i, int j) {
        if (i == 0 || j == 0)
            return "";
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return s1.charAt(i - 1) + traceback(i - 1, j - 1);
        } else {
            if (opt(i, j - 1) > opt(i - 1, j)) {
                return traceback(i, j - 1);
            } else {
                return traceback(i - 1, j);
            }
        }
    }
}
