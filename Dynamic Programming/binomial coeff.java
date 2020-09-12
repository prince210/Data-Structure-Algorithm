// Question Link : https://www.geeksforgeeks.org/binomial-coefficient-dp-9/

// Question desc : Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k).
                  // For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.


// code : 

public class binomial_coeff
{
    public static void main(String[] args) {
        int n = 4;
        int r = 3;

        Integer[][] dp = new Integer[n+1][r+1];
        int res = findBinomialCoeff(dp,n,r);

        System.out.println(res);
    }


    public static int findBinomialCoeff(Integer[][] dp,int n,int r)
    {
        if (r==n || r==0)
            return 1;

        if (r>n || n==0)
            return 0;

        if (dp[n][r]!=null)
            return dp[n][r];

        return dp[n][r] = findBinomialCoeff(dp,n-1,r)+findBinomialCoeff(dp,n-1,r-1);
    }
}
