// question link : https://www.geeksforgeeks.org/maximum-difference-zeros-ones-binary-string-set-2-time/

// question is very interesting

// question is tricky : here we need to find the size of substring
// where Max(diff(no. zeros - no. ones))
// general question

// solution is to initialize our dp arr with 1 for 0 and -1 for 1
// then apply kandane algo.
// Acc. to Kandane -> input : arr[] and
// choice is whether to start from here or continue with prev.

public class maximum_diff_zeros_one__imp
{
    public static void main(String[] args) {
        String str = "11000010001";

        maxDiffZero(str);
    }

    public static void maxDiffZero(String str)
    {
        int[] dp = new int[str.length()];
        // initialization our dp arr with 1 for 0 and -1 for 1
        char[] chararr = str.toCharArray();
        int k = 0;
        for (char ch : chararr)
        {
            if (ch == '1')
            {
                dp[k] = -1;
                k++;
            }
            else {
                dp[k] = 1;
                k++;
            }
        }


        // main work to apply kandane
        int max = Integer.MIN_VALUE;
        for (int i=1;i<str.length();i++)
        {
            dp[i] = Math.max(dp[i],dp[i]+dp[i-1]);

            max = Math.max(max,dp[i]);
        }

        System.out.println(max); 
    }
}
