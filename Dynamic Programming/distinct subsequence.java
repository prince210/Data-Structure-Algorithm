// Question Link : 

// Question Desc : 

public class distinct_subsq
{
    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit"; //target string which i have to count in S

        disinctSubsq(S,T);
    }

    public static void disinctSubsq(String s,String t)
    {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i=0;i<=s.length();i++)
        {
            dp[i][0] = 1;
        }

        for (int i=1;i<=s.length();i++)
        {
            for (int j=1;j<=t.length();j++)
            {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[s.length()][t.length()]);
    }
}
