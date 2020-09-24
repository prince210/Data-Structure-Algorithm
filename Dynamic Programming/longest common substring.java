// Question Link : https://www.geeksforgeeks.org/longest-common-substring-dp-29/

import java.util.Arrays;

public class longest_common_substring
{
    public static void main(String[] args) {
        String X = "zxabcdezy";
        String Y = "yzabcdezx";

        int[][] dp = new int[X.length()+1][Y.length()+1];
        for (int[] ar:dp)
            Arrays.fill(ar,-1);


//        System.out.println(lcs(X.length(),Y.length(),X,Y,dp));

        longestCommonSubstring(X,Y);
    }



    static int count  = 0;
    public static int lcs(int i, int j,String x,String y,int[][] dp) {

        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        lcs(i,j-1,x,y,dp);
        lcs(i-1,j,x,y,dp);

        if (x.charAt(i - 1) == y.charAt(j - 1)) {
            dp[i][j] = 1 + lcs(i - 1, j - 1,x,y,dp);
            count = 1+Math.max(count,dp[i][j]);
            return dp[i][j];
        }

        dp[i][j] = 0;
        return 0;
    }


    public static void longestCommonSubstring(String x,String y)
    {
        int[][] dp = new int[x.length()+1][y.length()+1];

        for (int i=0;i<=x.length();i++)
        {
            dp[i][0] = 0;
        }

        for (int j=0;j<=y.length();j++)
        {
            dp[0][j] = 0;
        }

        int largest = 0;
        for (int i=1;i<=x.length();i++)
        {
            for (int j=1;j<=y.length();j++)
            {
                if (x.charAt(i-1) == y.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];

                    if (dp[i][j]>largest)
                        largest = dp[i][j];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }


        for (int i=0;i<dp.length;i++)
        {
            for (int j=0;j<dp[0].length;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

//        System.out.println(dp[x.length()][y.length()]);
        System.out.println(largest);
    }
}
