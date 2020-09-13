// Question Link : https://www.geeksforgeeks.org/count-derangements-permutation-such-that-no-element-appears-in-its-original-position/

// Question desc : Derangements means arrangement such that no element occur in same position where they exists

public class Count_Derangements
{
    public static void main(String[] args) {
        int n = 1000; // that means arr containing 4 elements {0,1,2,3}

        Integer[] dp = new Integer[n+1];
        int res = countPemutationNoEle(dp,n);
        System.out.println(res);
    }

    public static int countPemutationNoEle(Integer[] dp,int n)
    {
        if (n == 0 || n==1)
            return 0;

        if (n == 2)
            return 1;

        if(dp[n]!=null)
            return dp[n];
        return dp[n] = (n-1)*(countPemutationNoEle(dp,n-1)+countPemutationNoEle(dp,n-2));
    }
}
