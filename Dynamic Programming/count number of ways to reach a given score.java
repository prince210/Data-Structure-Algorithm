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
}
