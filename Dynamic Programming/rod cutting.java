// Question Link : https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

// Question Desc : Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
                   For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


import java.util.Arrays;

public class cutting_a_rod
{
    public static void main(String[] args) {
        int length = 8;
        int[] costPerLen = {1,5,8,9,10,17,17,20};

        int[] dp = new int[costPerLen.length+1];
        Arrays.fill(dp,-1);

        int cost = MaxProfit(costPerLen,dp,length);
        System.out.println(cost);
    }

    public static int MaxProfit(int[] cost,int []dp,int n)
    {
        if (n<=0)
            return 0;

        if (dp[n]!=-1)
            return dp[n];

        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++)
        {
            max = Math.max(max,cost[i]+MaxProfit(cost,dp,n-i-1));
        }
        return dp[n] = max;
    }
}
