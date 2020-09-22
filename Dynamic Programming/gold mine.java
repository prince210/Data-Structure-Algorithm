// Question Link : https://www.geeksforgeeks.org/gold-mine-problem/


// code : 

import java.util.Arrays;

public class gold_mine
{
    public static void main(String[] args) {
        int[][] matrix = {{10, 33, 13, 15},
                {22, 21, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        int max = Integer.MIN_VALUE;
        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                int res = maxCoins(dp,matrix,i,j,matrix.length,matrix[0].length);

                if (res>max)
                    max = res;
            }
        }

        System.out.println(max);
    }

    public static int maxCoins(int[][] dp,int[][] matrix,int i,int j,int n,int m)
    {
        if (i<0 || i>=n || j<0 || j>=m)
            return 0;

        if (dp[i][j]!=-1)
            return dp[i][j];


        int x = matrix[i][j]+maxCoins(dp,matrix,i,j+1,n,m);
        int y = matrix[i][j]+maxCoins(dp,matrix,i-1,j+1,n,m);
        int z = matrix[i][j]+maxCoins(dp,matrix,i+1,j+1,n,m);

        return dp[i][j] = Math.max(x,Math.max(y,z));
    }
}
