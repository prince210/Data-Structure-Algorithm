// Question Link : https://leetcode.com/problems/edit-distance/

class edit_distance {

    public static void main(String[] args)
    {
        String word1 = "horse";
        String word2 = "ros";
        
        int minD = minDistance(word1,word2);
        System.out.println(minD);
    }
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++)
        {
            dp[i][0] = i;
        }
        
        for(int i=0;i<=m;i++)
        {
            dp[0][i] = i;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        
        return dp[n][m];
    }
}
