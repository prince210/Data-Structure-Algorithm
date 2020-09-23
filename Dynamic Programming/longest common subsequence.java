// Question Link : https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

public class longest_common_subsequence
{
    public static void main(String[] args) {
        String str = "abac"; //abcdgh
        String str2 = "cab";  // abedfhr

        Integer[][] dp = new Integer[str.length()+1][str2.length()+1];
//        int res = countSubsequence(str,str2,dp,str.length(),str2.length());
//        System.out.println(res);

        tabulation(str,str2);
    }

    public static int countSubsequence(String str1,String str2,Integer[][] dp,int n,int m)
    {
        // base case
        if (n==0 || m==0)
            return 0;

        if (dp[n][m]!=null)
        {
            return dp[n][m];
        }
        // recursive code
        if (str1.charAt(n-1) == str2.charAt(m-1))
        {
            return dp[n][m] = 1+countSubsequence(str1,str2,dp,n-1,m-1);
        }
        else
        {
            return dp[n][m] = Math.max(countSubsequence(str1,str2,dp,n,m-1),
                                            countSubsequence(str1,str2,dp,n-1,m));
        }
    }


    public static void tabulation(String temp1,String temp2)
    {
        int[][] dp = new int[temp1.length()+1][temp2.length()+2];

        // initialization
        for (int i =0;i<=temp1.length();i++)
        {
            dp[i][0] = 0;
        }

        for (int j=0;j<=temp2.length();j++)
        {
            dp[0][j] = 0;
        }

        // main code begins here
        for (int i=1;i<=temp1.length();i++)
        {
            for (int j=1;j<=temp2.length();j++)
            {
                if (temp1.charAt(i-1) == temp2.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[temp1.length()][temp2.length()]);
        printingLCS(dp,temp1,temp2);
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
