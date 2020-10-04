// Question Link : https://practice.geeksforgeeks.org/problems/number-of-coins1824/1

public class min_no_coins
{
    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount = 27;

        minCoins(coins,amount);
        int res = minCoins(coins,4,amount);
        System.out.println(res);
    }
    
    public int minCoins(int coins[], int M, int V) 
	{
	    Integer[] dp = new Integer[V+1];
	   // Arrays.fill(dp,V+1);
	   dp[0] = 0;
	    return getChange(coins,dp,M,V);
	}
	public static int getChange(int[] coins,Integer[] dp,int M,int V)
	{
	    if(V<0)
	        return -1;
	   
	    if(dp[V] != null)
	        return dp[V];
	    
	    int min = V+1;
	    for(int i = 0;i < M;i++)
	    {
	       // if(V-coins[i] < 0)
	       //     break;
	        int res = getChange(coins,dp,M,V-coins[i]);
	        
	        if(res != -1)
	            min = Math.min(min,1+res);
	    }
	    return dp[V] = min == V+1?-1:min;
	}

    public static void minCoins(int[] coins,int amount)
    {
        long[][] dp = new long[coins.length+1][amount+1];

        for (int i=1;i<=coins.length;i++)
        {
            dp[i][0] = 0;
        }

        for (int i=0;i<=amount;i++)
        {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i=1;i<=amount;i++)
        {
            if (i%coins[0] == 0)
                dp[1][i] = i/coins[0];
            else
                dp[1][i] = Integer.MAX_VALUE;
        }
        for (int i=2;i<=coins.length;i++)
        {
            for (int j=1;j<=amount;j++)
            {
                if (j>=coins[i-1])
                {
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int i=0;i<=coins.length;i++)
        {
            for (int j=0;j<=amount;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[coins.length][amount]);
    }
}
