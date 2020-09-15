// Question Link : 

// Question Desc : 

// Example : 2 3 5 6 8 10 	sum : 10
// subsets are (2,3,5) ,(2,8), (10)

public class count_subset_given_sum
{
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;
        countWithDP(arr,sum);

    }

    public static void countWithDP(int[] arr,int sum)
    {
        int[][] dp = new int[arr.length+1][sum+1];

        int n = arr.length;
        for (int i=0;i<=n;i++)
        {
            dp[i][0] = 1;
        }

        for (int j=1;j<=sum;j++)
        {
            dp[0][j] = 0;
        }


        for (int i=1;i<=n;i++)
        {
            for (int j=1;j<=sum;j++)
            {
                if (arr[i-1]<=j)
                {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else
                dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][sum]);
    }
}
