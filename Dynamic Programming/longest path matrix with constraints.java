// question Link : https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/

import java.util.Arrays;

public class longest_path_matrix_with_constraints
{
    public static void main(String[] args) {
        int[][] matrix = {{1,2,9},
                {5,3,8},
                {4,6,7}};

        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];


        int res = 1;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if (dp[i][j] == null) //we check this condition because if call longestPathLen()
                                    // it changes value of all nearby elements of (i,j) so we
                                    // don't want to apply longestPathLen() for previously computed result
                {                   // by this we reduce complexity to O(n^2)
                    longestPathLen(matrix,dp,i,j);
                }
                res = Math.max(res,dp[i][j]);
            }
        }


        System.out.println(res);
    }

    public static int longestPathLen(int[][] matrix,Integer[][] dp,int i,int j)
    {
        // base condition
        if (i<0 || i>=matrix.length || j<0 || j>=matrix.length)
        {
            return 0;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int w = Integer.MIN_VALUE;
        int z = Integer.MIN_VALUE;

        // recursive function call
        if (i>0 && (matrix[i][j]+1 == matrix[i-1][j])) // going up
        {
            x = dp[i][j] = 1+longestPathLen(matrix,dp,i-1,j);
        }
        if (i<matrix.length-1 && (matrix[i][j]+1 == matrix[i+1][j])) //going down
        {
            y = dp[i][j] = 1 + longestPathLen(matrix,dp,i+1,j);
        }
        if (j>0 && (matrix[i][j]+1 == matrix[i][j-1])) // going left
        {
            w = dp[i][j] = 1 + longestPathLen(matrix,dp,i,j-1);
        }
        if (j<matrix.length-1 && (matrix[i][j]+1 == matrix[i][j+1])) // going right
        {
            z = dp[i][j] = 1 + longestPathLen(matrix,dp,i,j+1);
        }
        return dp[i][j] = Math.max(x,Math.max(y,Math.max(w,Math.max(z,1))));
    }
}
