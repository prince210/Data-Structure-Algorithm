// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {

    public static void main(String[] args)
    {
        int []arr = {3,2,6,5,0,3};
        int k = 2;
        
        int res = maxProfit(k,arr);
        System.out.println(res);
    }
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || prices == null)
        {
            return 0;
        }

        int n = prices.length;
        if(k >= n/2)
        {
            int maxProf = 0;
            for(int i = 1;i < n;i++)
            {
                if(prices[i]>prices[i-1])
                {
                    maxProf += (prices[i] - prices[i-1]);
                }
            }
            return maxProf;
            
        }
        int[][] dp = new int[k+1][n];
        
        for(int i = 1;i <= k;i++)
        {
            int maxDiff = -prices[0];
            for(int j = 1;j < n;j++)
            {
                dp[i][j] = dp[i][j-1];
                dp[i][j] = Math.max(dp[i][j],maxDiff + prices[j]);
                maxDiff = Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        
        return dp[k][n-1];
    }
}
