import java.util.Arrays;

public class min_removal_such_max_minus_min_k
{
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 9, 10, 11, 12, 17, 20} ;
        int k = 4;

        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[arr.length-1];
        Integer[][] dp = new Integer[arr.length+1][arr.length+1];

        int res = minRemoval(arr,dp,k,0,arr.length-1);
        System.out.println(res);
    }

    public static int minRemoval(int[] arr,Integer[][] dp,int k,int i,int j)
    {
        if (i>=j)
        {
            return 0;
        }

        if (arr[j]-arr[i]<=k)
            return 0;

        if (dp[i][j]!=null)
            return dp[i][j];

        return dp[i][j] = 1+Math.min(minRemoval(arr,dp,k,i+1,j),minRemoval(arr,dp,k,i,j-1));
    }
}
