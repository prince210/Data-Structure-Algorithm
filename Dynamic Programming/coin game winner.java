public class coin_game_winner_every_player_3_choice
{
    public static void main(String[] args) {
        int n = 5;
        int x = 3;
        int y = 4;

        Boolean[] dp = new Boolean[n+1];
        boolean res = winner(n,x,y,0,dp);
        if (res)
            System.out.println("A");
        else
            System.out.println("B");
//        System.out.println(res);
    }

    public static boolean winner(int n,int x,int y,int level,Boolean[] dp)
    {
        if (n<0)
        {
            return false;
        }

        if (n == 0 && level%2!=0)
            return true;

        if (dp[n]!=null)
            return dp[n];

        dp[n] = winner(n-x,x,y,level+1,dp) || winner(n-y,x,y,level+1,dp)
                || winner(n-1,x,y,level+1,dp);
        return dp[n];
    }
}
