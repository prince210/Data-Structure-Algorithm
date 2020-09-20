// Question Link : 

//  Question Desc : 

public class equal_sum_partition
{
    public static void main(String[] args) {
        int []arr = {1,3,5};
        int sum = 0 ;
        for (int i=0;i<arr.length;i++)
        {
            sum += arr[i];
        }
        if (sum%2!=0)
            return;

        sum = sum/2;
        Boolean [][]dp = new Boolean[arr.length+1][sum+1];
        boolean res = equalSumPartition(arr,dp,sum/2,arr.length);

        System.out.println(res);
        System.out.println(dp[arr.length][sum]);
        for (int i=0;i<=arr.length;i++)
        {
            for (int j=0;j<=sum;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static boolean equalSumPartition(int[] arr,Boolean [][]dp,int sum,int n)
    {
        if (n==0 || sum < 0)
            return false;
        if (sum == 0)
            return true;

        if (dp[n][sum]!=null)
            return dp[n][sum];

        System.out.println(sum);
        return dp[n][sum] = equalSumPartition(arr,dp,sum - arr[n-1],n-1)
                            || equalSumPartition(arr,dp,sum,n-1);
    }
}
