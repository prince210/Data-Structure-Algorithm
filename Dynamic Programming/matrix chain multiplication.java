// Question Link : https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

// min cost to multiply matrix
public class Matrix_chain_mul
{
    public static void main(String[] args) {

//        int[] dimensionArr = {1,3,1,5,8,1}; // if size = 5 then there will be four matrix that are
                                                // A1(40,20) A2(20,30) A3(30,10) A4(10,30)
        int[] dimensionArr = {40,20,30,10,30};
        int n = dimensionArr.length;
        Integer[][] dp = new Integer[n][n];

        int res = minCostToMul(dp,dimensionArr,1,n-1);
        System.out.println(res);

        for (int h=0;h<n;h++)
        {
            for (int l = 0;l<n;l++)
            {
                System.out.print(dp[h][l]+" ");
            }
            System.out.println();
        }
    }

    public static int minCostToMul(Integer[][] dp,int[] dimensArr,int i,int j)
    {
        if (i>=j) // if i==j then we have only single element dimensArr which represent only one dimension
                    // so result not possible with even i == j.
        {
            return 0;
        }

        if (dp[i][j]!=null)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i;k<j;k++) //to partition the given problem eg- if we cut cake 20%,80% then cost of 20% + cost of 80%
                                // similarly we have to find cost of each 1 to 100% exactly like that we try out all possibility an get optimal soln
        {
                        // c1                           c2                               c3
            int temp= minCostToMul(dp,dimensArr,i,k)+minCostToMul(dp,dimensArr,k+1,j)+
                        dimensArr[i-1]*dimensArr[k]*dimensArr[j];

            if (temp<min)
                min = temp;

//            System.out.println(temp);
        }
        dp[i][j] = min;
        return min;
    }
}
