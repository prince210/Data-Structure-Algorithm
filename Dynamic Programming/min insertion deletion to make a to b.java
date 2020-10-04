// Question Link :  

public class min_insertion_deletion_a_to_b
{
    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";

        // find minimum insertion and deletion to make string a to string b
        LCS(a,b);
    }

    public static void LCS(String a,String b)
    {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i=1;i<=a.length();i++)
        {
            for (int j=1;j<=b.length();j++)
            {
                if (a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        int Lcs = dp[a.length()][b.length()];
        System.out.println(Lcs);

        System.out.println("min deletion is "+(a.length()-Lcs)+" "+"inserion is "+(b.length()-Lcs));

    }
}
