// Question Link : 

// Question Desc :

// code : 

public class longest_palindromic_substr
{
    public static void main(String[] args) {
        String str = "aaaabbaa";

        longestPalindromeSubstr(str);
    }

    public static void longestPalindromeSubstr(String str)
    {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        // initialization
        int start = 0; // start means start of the string when it is palindrome
        int maxLen = 1; // string of length 1 is always palindrome
        for (int i=0;i<n;i++)
        {
            dp[i][i] = true;
        }

        for (int i=0;i<n-1;i++)
        {
            int j = i+1;
            if (str.charAt(i) == str.charAt(j))
            {
                dp[i][j] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int i=3;i<=n;i++)
        {
            for (int k=0;k<n-i+1;k++)
            {
                int j = k+(i-1); //here i-1 is difference for eg. 0 2 -> diff 2(i-1)
                if (str.charAt(k) == str.charAt(j)
                        && dp[k+1][j-1])
                {
                    dp[k][j] = true;
                    if (i>maxLen) {
                        start = k;
                        maxLen = i;
                    }
                }
            }
        }
        System.out.println("maximum len of palindromic substr"+maxLen);
        printStr(str,start,start+maxLen);
    }
    public static void printStr(String str,int start,int maxLen)
    {
        System.out.println(str.substring(start,maxLen));
    }
}
