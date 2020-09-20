// Question Link : 

// Question Desc : 

public class findIfStringKPalindrome
{
    public static void main(String[] args) {
//        String str = "abcdeca";
//        int k = 2;


        String str = "acdcb";
        int k = 1;
        kPalindrome(str,k);
    }

    public static void kPalindrome(String str,int k)
    {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=n;j++)
            {
                if (str.charAt(i-1) == str.charAt(n-j))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int res = n - dp[n][n];
        if (res <= k)
            System.out.println("Yes");
        else
            System.out.println("No");
        System.out.println(dp[n][n]);
    }
}
