// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class stock_buy_sell_2
{
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};

        int n = arr.length;

        int res = maxProfit(arr,n);
        System.out.println(res);
    }

    // Valley Peak Approach------------------> Efficient One
    // Time - O(n)          space - O(1)
    public static int maxProfit(int []arr,int n)
    {
        int profit = 0;

        for (int i=1;i<n;i++)
        {
            if (arr[i]>arr[i-1])
                profit += arr[i]-arr[i-1];
        }
        return profit;
    }
}
