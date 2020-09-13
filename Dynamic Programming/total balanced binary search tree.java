public class count_balanced_binary_tree_height_h
{
    static int modulo = 1000000007; // modulo arithmetic because answer may be high
    public static void main(String[] args) {
        int h = 10;  // tree of height 4

        // count all the balanced binary search tree of height h
        // just like combination of tree of height 4

        Integer[] dp = new Integer[h+1];
        int res = countBalancedTreeHeightH(h,dp);
        System.out.println(res);

        for (int i=0;i<=h;i++)
        {
            System.out.print(dp[i]+" ");
        }
    }

    public static int countBalancedTreeHeightH(int h,Integer[] dp)
    {
        if (h == 0)
            return 1;

        if (h == 1)
            return 1;

        if (dp[h]!=null)
            return dp[h];

        return dp[h] = (countBalancedTreeHeightH(h-1,dp)*((2*countBalancedTreeHeightH(h-2,dp))%modulo+countBalancedTreeHeightH(h-1,dp))%modulo)%modulo;
    }
}
