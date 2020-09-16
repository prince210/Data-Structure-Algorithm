// Question Link : https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

// Question Desc : Example subset is {1,6,11,5} --> divided into two partition such that {1,6,5} and {11} diff is 12 - 11 = 1

class partition_subsets_with_min_sum_of_diff
{
   public static void main(String[] args)
   {
       int[] arr = {1,6,11,5};
       minDiffPartition();
   }

   // Ex - arr : 1 6 11 5
   public static void minDiffPartition(int[] arr)
   {
       int n = arr.length;
       int sum = 0;

       for(int i = 0;i < n;i++)
       {
	   sum += arr[i];
       }

       boolean[][] dp = new boolean[n+1][sum+1];
       for(int i = 0;i <= n;i++)
       {
	   dp[i][0] = true;
       }
       for(int i = 1;i <= sum;i++)
       {
	   dp[0][i] = false;
       }

       for(int i = 1;i <= n;i++)
       {
	   for(int j = 1;j <= sum;j++)
	   {
		if(arr[i-1] <= j)
		{
		    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]]; 
		}
		else
		{
		     dp[i][j] = dp[i-1][j];
		}
	   }
       }

       int minDiff = Integer.MAX_VALUE;
       for(int j = sum/2;j>=0;j--)
       {
	    if(dp[n][j])
	    {
		minDiff = sum - 2*j;
		break;
	    }   
       }
       System.out.println(minDiff);
   }
}
