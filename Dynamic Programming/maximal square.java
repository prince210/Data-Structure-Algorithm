// Question Link : https://leetcode.com/problems/maximal-square/


import java.util.Arrays;

public class maximum_size_square_matrix_with_1s
{
    public static void main(String[] args) {
        int[][] arr =  {{0,1,1,0,1},
                        {1,1,0,1,0},
                        {0,1,1,1,0},
                        {1,1,1,1,0},
                        {1,1,1,1,1},
                        {0,0,0,0,0}};

        int[][] dp = new int[arr.length][arr[0].length];
        for (int i=0;i<arr.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[0].length;j++)
            {

//                maxSizeSubMatrix(arr,dp,i,j);
                max = Math.max(max,maxSizeSubMatrix(arr,dp,i,j));
            }
        }
        System.out.println(max);
    }

    public static int maxSizeSubMatrix(int[][] arr,int [][]dp,int i,int j)
    {
        if (i<0 || i>=arr.length || j<0 || j>=arr[0].length)
            return 0;

        if (dp[i][j]!=-1)
            return dp[i][j];

        if (arr[i][j] == 0)
            return 0;

        int x = 0;
        int y = 0;
        int z = 0;

        if (j<arr[0].length-1 && arr[i][j]==1)
        {
            x = maxSizeSubMatrix(arr,dp,i,j+1);
        }
        if (i<arr.length-1 && j<arr[0].length-1 && arr[i][j]==1)
        {
            y = maxSizeSubMatrix(arr,dp,i+1,j+1);
        }
        if (i<arr.length-1 && arr[i][j]==1)
        {
            z = maxSizeSubMatrix(arr,dp,i+1,j);
        }

        return dp[i][j] = 1+Math.min(x,Math.min(y,z));
    }
}
