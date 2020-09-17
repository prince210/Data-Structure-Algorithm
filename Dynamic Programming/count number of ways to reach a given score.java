import java.util.*;

public class countWaysToReachScore
{
    public static void main (String[] args)
    {
	int n = 20;
	Integer[][] dp = new Integer[3][n+1];
	
	int[] ways = {3,5,10};
	int count = countWays(n,dp,ways,0);
	System.out.println(count);

    	// method 2 
	countWaysUsingTabulation(n);
    }

    public static int countWays(int n,Integer [][]dp,int[] ways,int i)
    {
	if(n == 0)
	{
	    return 1;
	}
	if(n<0 || i == ways.length)
	{
	    return 0;
	}

	if(dp[i][n]!=null)
	{
	    return dp[i][n];
	}

	int count = 0;
	count += countWays(n-ways[i],dp,ways,i)+countWays(n,dp,ways,i+1);
	return dp[i][n] = count;
    }
	
    // method - 2
    public static void countWaysUsingTabulation(int n)
    {
	 int[] dp = new int[n+1];
	 dp[0] = 1; // if n == 0 we can always archive this score without doing anything
	    
	 for(int i = 3;i <= n;i++)
	 {
	      dp[i] += dp[i-3];
	 }
	 
	 for(int i = 5;i <= n;i++)
	 {
	      dp[i] += dp[i-5];
	 }
	 
	 for(int i = 10;i <= n;i++)
	 {
	      dp[i] += dp[i-10];
	 }
	 
	 System.out.println(dp[n]);
    }
}
