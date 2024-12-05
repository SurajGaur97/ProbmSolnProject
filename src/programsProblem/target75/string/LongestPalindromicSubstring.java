package programsProblem.target75.string;

import programsProblem.utils.DriverClass;

import java.util.Arrays;

public class LongestPalindromicSubstring implements DriverClass<String> {
    @Override
    public void driverMethod(){
        String s = "babbab";
        printElement(longestPalindrome1(s));
    }

    public String longestPalindrome(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        int[] ans = new int[2];

        //Base condition: covered 1 and 2 size window
        for(int i = 0;i < len;i++)
            dp[i][i] = 1;

        for(int i = 0;i < len - 1;i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = 1;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        //Covering 3 size window and all-size differences 2 or more
        int srt = 0, end = 2, window = 3;
        while (end < len){
            if(s.charAt(srt) == s.charAt(end) && dp[srt + 1][end - 1] == 1){
                dp[srt][end] = 1;
                ans[0] = srt;
                ans[1] = end;
            }

            if(end == len - 1){
                srt = 0;
                end = window++;
            } else {
                srt++;
                end++;
            }
        }

        return s.substring(ans[0], ans[1] + 1);
    }

    public String longestPalindrome1(String s){
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        int max = 0, srt = 0, end = 0;
        for(int i = 0;i < s.length();i++){
            for(int j = i;j < s.length();j++){
                if(solve(i, j, s, dp) == 1 && max < (j - i)){
                    srt = i;
                    end = j;
                    max = j - i;
                }
            }
        }
        return s.substring(srt, end + 1);
    }

    private int solve(int srt, int end, String s, int[][] dp){
        if(srt >= end)
            return 1;

        if(dp[srt][end] != -1)
            return dp[srt][end];

        if(s.charAt(srt) == s.charAt(end))
            return dp[srt][end] = solve(srt + 1, end - 1, s, dp);
        else
            return dp[srt][end] = 0;
    }
}
