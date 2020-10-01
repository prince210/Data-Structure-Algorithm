// question link : 	https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
import java.util.Arrays;


// we have to consider that no three element are consecutive
// so we will consider 1 element sum (as arr[i]+moveTo(i+2)) ---- (1)
// or, we will consider 2 element sum (as arr[i]+arr[i+1]+moveTo(i+3)) ---- (3)
// otherwise, do not include anything and moveTo(i+1) ----- (3)
// final answer will be max(1,2,3) cases.

public class maximum_subsq_sum_with_no_three_consecutive
{
    public static void main(String[] args) {
//        int []arr = {3000,2000,1000,3,10};

        int[] arr = {1,2,3,4,5,6,7};
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);

        int res = maximumSubSq(arr,dp,arr.length);
        System.out.println(res);

        for (int ele:dp)
        {
            System.out.print(ele+" ");
        }
     }

    public static int maximumSubSq(int[] arr,int []dp,int n)
    {
        if (n<0)
            return 0;

        if (n == 0)
            return dp[n] = 0;

        if (n==1)
            return dp[n] = arr[0];

        if (n==2)
            return dp[n] = arr[0]+arr[1];

        if (dp[n]!=-1)
            return dp[n];

        return dp[n] = Math.max(maximumSubSq(arr,dp,n-1),Math.max(arr[n-1]+maximumSubSq(arr,dp,n-2),arr[n-1]+arr[n-2]+maximumSubSq(arr,dp,n-3)));
    }
}
