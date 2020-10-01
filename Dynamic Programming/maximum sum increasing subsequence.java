// very interesting questions
import java.util.Arrays;

public class maximum_sum_inc_subsq
{
    public static void main(String[] args) {
//        int[] arr = new int[]{468,335,501,170,725,479,359,963,465,706,146,282,828,962,492,996,943,828,437,392,605,903,154,293,383,422,717,719,896,448,727,772,539,870,913,668,300,36,895,704,812,323};
            int[] arr = {1,101,2,3,100,4,5};
        maximumIncSum(arr);
    }

    public static void maximumIncSum(int []arr)
    {
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp,1);

        int[] maxSum = new int[n];
        for (int i=0;i<n;i++)
        {
            maxSum[i] = arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i=1;i<n;i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if (arr[i]>arr[j])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1); //it is additional required only
                                                    // if we want to output longest increasing subSequence
                    maxSum[i] = Math.max(maxSum[i],maxSum[j]+arr[i]);
                }
            }
            max = Math.max(max,maxSum[i]);
        }
        max = Math.max(max,maxSum[0]);
        System.out.println(max);
    }
}
