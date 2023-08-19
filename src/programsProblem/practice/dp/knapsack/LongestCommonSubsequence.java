package programsProblem.practice.dp.knapsack;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
//        return lcs(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
//        return lcsIter(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());

        int[][] t = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return lcsMemoisation(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length(), t);
    }

    public int longestCommonSubsequence(String text1, String text2, String text3) {
        int[][][] t = new int[text1.length() + 1][text2.length() + 1][text3.length() + 1];
        for (int[][] row : t) {
            for(int[] crow: row)
                Arrays.fill(crow, -1);
        }

        return lcs3DMemoisation(text1.toCharArray(), text2.toCharArray(), text3.toCharArray(),
                text1.length(), text2.length(), text3.length(), t);
    }

    private int lcs3DMemoisation(char[] x, char[] y, char[] z, int n, int m, int o, int[][][] t) {
        if(n == 0 || m == 0 || o == 0) return 0;

        if(t[n][m][o] != -1) return t[n][m][o];

        if(x[n - 1] == y[m - 1] && y[m - 1] == z[o - 1]) {
            t[n][m][o] = 1 + lcs3DMemoisation(x, y, z, n - 1, m - 1, o - 1, t);
            return t[n][m][o];
        }
        else {
            t[n][m][o] = Math.max(lcs3DMemoisation(x, y, z, n, m, o - 1, t), Math.max(lcs3DMemoisation(x, y, z, n, m - 1, o, t), lcs3DMemoisation(x, y, z, n - 1, m, o, t)));
            return t[n][m][o];
        }
    }

    private int lcsMemoisation(char[] x, char[] y, int n, int m, int[][] t) {
        if(n == 0 || m == 0) {
            return 0;
        }

        //returning those values which are already calculated.
        if(t[n][m] != -1) return t[n][m];   //memoized value;

        if(x[n - 1] == y[m - 1]) {
            t[n][m] = 1 + lcsMemoisation(x, y, n - 1, m - 1, t);  //Memorizing values
            return t[n][m];
        }
        else {
            t[n][m] = Math.max(lcsMemoisation(x, y, n, m - 1, t), lcsMemoisation(x, y, n - 1, m, t));   //Memorizing values
            return t[n][m];
        }
    }

    private int lcsIter(char[] x, char[] y, int n, int m) {
        int[][] t = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(x[i - 1] == y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                }
                else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        return t[n][m];
    }

    private int lcs(char[] x, char[] y, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }

        if(x[n - 1] == y[m - 1]) {
            return 1 + lcs(x, y, n - 1, m - 1);
        }
        else {
            return Math.max(lcs(x, y, n, m - 1), lcs(x, y, n - 1, m));
        }
    }
}
