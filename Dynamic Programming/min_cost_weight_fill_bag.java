// Question Link : 

public class min_cost_fill_weight_in_bag
{
    public static void main(String[] args) {
        int[] cost = {-1,-1,4,5,-1};
        int W = 5;

        Integer[] dp = new Integer[W+1];
        int res = minCostBag(W,cost,dp);
        System.out.println(res);

        res = cutRod(cost,cost.length);
        System.out.println(res);
    }


    public static int minCostBag(int W,int []cost,Integer []dp)
    {
        if (W <=0)
            return 0;

        if (dp[W]!=null)
            return dp[W];

        int minCost = Integer.MIN_VALUE;
        for (int i=0;i<W;i++)
        {
            minCost = Math.max(minCost,cost[i]+minCostBag(W-i-1,cost,dp));
        }
        return dp[W] = minCost;
    }

    static int cutRod(int price[], int n)
    {
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;

        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i<n; i++)
            max_val = Math.max(max_val,
                    price[i] + cutRod(price, n-i-1));

        return max_val;
    }
}
