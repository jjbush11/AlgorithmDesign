// jdh CS3240A/CS5990A Fall 2023  grad-student problem
// longest common subsequence
// this is actually a specific case of sequence alignment,
// with delta > 0 and alpha very large

//import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String argv[]) {
        testThree();
    }

    public static void testOne() {
        String s1 = "ABAZDCZWYY";
        String s2 = "BACBADXYXWY";

        Analyzer a = new Analyzer();
        a.LCS(s1, s2);
    }

    public static void testTwo() {
        String s1 = "AWBC";
        String s2 = "XYZAAACCIJBKC";

        Analyzer a = new Analyzer();
        a.LCS(s1, s2);
    }

    public static void testThree() {
        String s1 = "AWBC";//"XYZABDC";
        String s2 = "XYZAAACCIJBKC";//"ABDQARC";

        Analyzer a = new Analyzer();
        System.out.println(a.LCS(s1, s2));
    }
}