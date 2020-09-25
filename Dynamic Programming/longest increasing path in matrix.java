// longest increasing path in matrix

// question link : https://www.geeksforgeeks.org/longest-increasing-path-matrix/?ref=rp
import java.util.Arrays;

// question desc : we can move only in two directions i.e. either in right or down
// we have to find longest inc. path in matrix

public class Main
{
    public static void main(String[] args) {
        int n = 4;
        int m = 4;

        int[][] matrix =
                {{1,2,3,4},
                {2,2,3,4},
                {3,2,3,4},
                {4,5,6,7}};

        int [][]dp = new int[n][m];
        for (int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        longestPathMatrix(matrix,dp,0,0,n,m);

        int res = 1;
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                res = Math.max(res,dp[i][j]);
            }
        }

        System.out.println(res);
    }

    public static int longestPathMatrix(int[][] matrix, int[][] dp,int i,int j,int n,int m)
    {
	if(i<0 || i>=n || j<0 || j>=m)
	{
	    return 0;
	}

	if(dp[i][j] != -1)
	{
	     return dp[i][j];
	}

	int a = Integer.MIN_VALUE;
	int b = Integer.MIN_VALUE;

	if(j+1<m && matrix[i][j]<matrix[i][j+1])
	{
	     a = dp[i][j] = 1 + longestPathMatrix(matrix,dp,i,j+1,n,m);
	}

	if(i+1<n && matrix[i][j]<matrix[i+1][j])
	{
	     b = dp[i][j] = 1 + longestPathMatrix(matrix,dp,i+1,j,n,m);
	}

	return dp[i][j] = Math.max(a,Math.max(b,1));
    }
}
