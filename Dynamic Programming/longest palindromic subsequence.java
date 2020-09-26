// Question Link : https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

public class Longest_palindromic_subsequence
{
    public static void main(String[] args) {
        String x = "BBABCBCAB";

        longestPalindromicSubsequence(x);
    }

    public static void longestPalindromicSubsequence(String x)
    {
        int[][] dp = new int[x.length()+1][x.length()+1];

        for (int i=1;i<=x.length();i++)
        {
            for (int j=1;j<=x.length();j++)
            {
                if (x.charAt(i-1) == x.charAt(x.length()-j))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    System.out.print(dp[i][j]+" ");
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    System.out.print(dp[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println(dp[x.length()][x.length()]);
        StringBuilder y = new StringBuilder(x);
        y.reverse();
        printingLCS(dp,x,y.toString());
    }
    public static void printingLCS(int [][]dp,String x,String y)
    {
        StringBuilder str = new StringBuilder("");
        int i = x.length();
        int j = y.length();

        while (i>0 && j>0)
        {
            if (x.charAt(i-1) == y.charAt(j-1))
            {
                str.append(x.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if (dp[i-1][j] > dp[i][j-1])
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }
        }
        System.out.println(str.reverse());
    }
}
