// very important and interesting question

// question link : https://www.geeksforgeeks.org/count-subsequences-product-less-k/

// question desc : we have to find subSequence/(best word is subset) with product less than k

public class count_subsq_product_less_k
{
    public static void main(String[] args) {
        int k = 50;
        int[] arr = {4,8,7,2};

        countSubsqLessThanK(k,arr);
    }

    // this problem is very similar to knapsack
    // because given an input arr(as arr of knapsack) and k (as weight)
    // also we have two choices whether to include arr[i] or not based on condition of k as shown on line 28
    // dp[i][j] = 1 + dp[i-1][j]+dp[i-1][j/arr[i-1]];

    static void countSubsqLessThanK(int k,int []arr)
    {
        int n = arr.length;
        int[][] dp = new int[arr.length+1][k+1];

        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=k;j++)
            {
                if (arr[i-1]<=j && arr[i-1]>0)
                {
                    //             include     exclude
                    dp[i][j] = 1 + dp[i-1][j]+dp[i-1][j/arr[i-1]];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[arr.length][k]);
    }
}
