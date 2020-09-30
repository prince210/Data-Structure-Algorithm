// Quetion Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


class Solution {
    public static void main(String[] args)
    {
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
    
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null)
        {
            return 0;
        }
        
        int n = prices.length;
        int[][] dp = new int[3][n];
        for(int i = 1;i <= 2;i++)
        {
            int maxDiff = -prices[0];
            for(int j = 1;j < n;j++)
            {
                dp[i][j] = dp[i][j-1];
                dp[i][j] = Math.max(dp[i][j],maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        
        return dp[2][n-1];
    }
}
