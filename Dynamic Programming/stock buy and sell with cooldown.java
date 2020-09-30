// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/


class stock_buy_sell_cooldown
{
   public static void main(String[] args)
   {
       int[] stocks = {1,2,3,0,2};
       int res = maxProfit(stocks);
       System.out.println(res);
   }
   
   public static return maxProfit(int[] arr)
   {
      if(arr == null || arr.length == 0)
         return 0;
       
       int n = arr.length;
       Integer[] dp = new Integer[n];
      return sellWithCoolDown(arr,0,dp);
   }
   
   public static int sellWithCoolDown(int[] arr,int n,Integer[] dp)
    {
        if(n>=arr.length)
        {
            return 0;
        }
        
        if(dp[n] != null)
        {
            return dp[n];
        }
        
        int maxVal = 0;
        for(int i = n+1;i < arr.length;i++)
        {
            if(arr[n] < arr[i])
            {
                maxVal = Math.max(maxVal,arr[i] - arr[n] + sellWithCoolDown(arr,i+2,dp));
            }
        }
        
        maxVal = Math.max(maxVal,sellWithCoolDown(arr,n+1,dp));
        return dp[n] = maxVal;
    }
}
