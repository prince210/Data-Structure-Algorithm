// Question Link : https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

import java.util.Arrays;

public class longest_inc_subSequence
{
    public static void main(String[] args) {
        int[] arr = {1,17,5,10,13,15,10,5,16,8};

        longestIncSusbsq(arr);
    }

    public static void longestIncSusbsq(int[] arr)
    {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        int max = 1;
        for (int i=1;i<arr.length;i++)
        {
//            dp[i] = dp[i-1];
            for (int j=i-1;j>=0;j--)
            {
                if (arr[i]>arr[j])
                {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            if (dp[i]>max)
                max = dp[i];
            System.out.print(dp[i]+" ");
        }

        System.out.println();
        System.out.println(dp[arr.length-1]);
    }
}
