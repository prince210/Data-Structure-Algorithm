// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

class Solution {

    public static void main(String[] args)
    {
        int []prices = {7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
    public int maxProfit(int[] arr) {
        if(arr.length == 0 || arr == null)
            return 0;
        
        int n = arr.length;
        int[] minArr = new int[n];
        int[] maxArr = new int[n];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++)
        {
            min = Math.min(min,arr[i]);
            minArr[i] = min;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = n-1;i>=0;i--)
        {
            max = Math.max(max,arr[i]);
            maxArr[i] = max;
        }
        
        int profit = 0;
        for(int i = 0;i < n;i++)
        {
            profit = Math.max(profit,maxArr[i] - minArr[i]);
        }
        
        return profit;
    }
}
