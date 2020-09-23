// question link : https://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/


// Find Longest common subSequence of three string {approach is very similar but
// one consideration that is first we have to check for 1st string as leader and make
// characters of 1st string equal to other string {see else body}
// second case is we have to check if two strings having character at i,j,k index common
// so search for remaining string of same character

// our output is max of (max1 for case 1 and max2 for case 2)

public class LCS_3_strings
{
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "geeksfor";
        String str3 = "geeksforgeeks";

//        int res1 = LCSofThreeStrings(str1,str2);
//        int res2 = LCSofThreeStrings(str2,str3);
//        int res3 = LCSofThreeStrings(str1,str3);

//        System.out.println(res3);
//        int res = Math.min(res1,Math.min(res2,res3));
//        System.out.println(res);
        LCSofThreeStrings(str1,str2,str3);
    }

    public static void LCSofThreeStrings(String temp1,String temp2,String temp3)
    {
        int m = temp1.length();
        int n = temp2.length();
        int p = temp3.length();
        int [][][]dp = new int[m+1][n+1][p+1];

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=1;i<=m;i++)
        {
            for (int j=1;j<=n;j++)
            {
                for (int k=1;k<=p;k++) {
                    if (temp1.charAt(i - 1) == temp2.charAt(j - 1) && temp2.charAt(j - 1) == temp3.charAt(k - 1) && temp1.charAt(i - 1) == temp3.charAt(k - 1))
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    else {
                        max1 = Math.max(dp[i][j - 1][k - 1], Math.max(dp[i - 1][j][k - 1], dp[i - 1][j - 1][k]));
                        max2 = Math.max(dp[i][j - 1][k], Math.max(dp[i][j][k - 1], dp[i - 1][j][k]));

                        dp[i][j][k] = max = Math.max(max1, max2);
                    }
                }
            }
        }

        System.out.println(dp[temp1.length()][temp2.length()][temp3.length()]);
    }
}
