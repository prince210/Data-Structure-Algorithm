//question link : https://www.geeksforgeeks.org/minimum-time-write-characters-using-insert-delete-copy-operation/

// very interesting question where you will get stuck in infinite loop -> beacuse you can insert character and at the same time you delete character
// also, the question is tricky always we have to perform only two o/p either insert or copy
// delete is required in case of odd strings for example you have to make 7
// then you can do o/p like Insert(len of str 1)+Copy(len of str 2)+copy(len of str 4)+copy(len of str 8)+   delete(len of str 7) -- here delete is required
public class min_time_write_characters_Insert_del_copy
{
    public static void main(String[] args) {
        int N = 10;
        int[] cost = {2,5,4}; // cost of insert,remove,copy

        Integer[] dp = new Integer[N+1];
        int res = minTime(N,cost,dp,N);
        System.out.println(res);

        int op = minTimeForWritingChars(N,2,5,4);
        System.out.println(op);
    }

    public static int minTime(int n,int []cost,Integer[] dp,int m)
    {
        if (n>m || n<=0)
            return 0;

        if (n == 1) {
            return 1;
        }

        if (dp[n]!=null)
            return dp[n];

//        System.out.println(n);
        if (n %2 ==0) {
            return dp[n] = Math.min(cost[0] + minTime(n - 1, cost, dp, m), cost[2] + minTime(n / 2, cost, dp, m));
        }
        else
        {
            return dp[n] = Math.min(cost[0] + minTime(n - 1, cost, dp, m), cost[2] + cost[1] + minTime((n+1)/2, cost, dp, m));
        }
        }

    static int minTimeForWritingChars(int N, int insert,
                                      int remove, int copy)
    {
        if (N == 0)
            return 0;
        if (N == 1)
            return insert;

        // declare dp array and initialize with zero
        int dp[] = new int [N + 1];


        // loop for 'N' number of times
        for (int i = 1; i <= N; i++)
        {
            /* if current char count is even then
                choose minimum from result for (i-1)
                chars and time for insertion and
                result for half of chars and time
                for copy */
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i-1] + insert, dp[i/2] + copy);

            /* if current char count is odd then
                choose minimum from
                result for (i-1) chars and time for
                insertion and
                result for half of chars and time for
                copy and one extra character deletion*/
            else
                dp[i] = Math.min(dp[i-1] + insert,
                        dp[(i+1)/2] + copy + remove);
        }
        return dp[N];
    }
}
