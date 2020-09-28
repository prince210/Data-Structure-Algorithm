// Question Link : https://practice.geeksforgeeks.org/problems/dice-throw5349/1

public class dice_throw_amazon
{
    public static void main(String[] args) {
        int n = 2;
        int m = 6;
        int x = 7;

        Integer[][] dp = new Integer[n+1][x+1];
        int res = countWays(n,m,x,dp);
        System.out.println(res);
    }

    public static int countWays(int n,int m,int x,Integer[][] dp)
    {
        if (x == 0 && n == 0)
        {
            return 1;
        }

        if (n == 0 || x == 0)
        {
            return 0;
        }

        if (dp[n][x] != null)
            return dp[n][x];

        int count = 0;
        for (int i = 1;i <= m;i++)
        {
            if ((x - i)<0)
                break;
            count += countWays(n-1,m,x-i,dp);
        }
        dp[n][x] = count;
        return count;
    }
}
