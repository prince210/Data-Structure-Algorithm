// question link : https://leetcode.com/problems/matrix-block-sum/

// prerequisite is 2d prefix sum

class Solution {
    public int[][] matrixBlockSum(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return new int[][]{{}};
        
        if(k == 0)
            return matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1;i <= m;i++)
        {
            for(int j = 1;j <= n;j++)
            {
                dp[i][j] = matrix[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
        int[][] res = new int[m][n];
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j < n;j++)
            {
                int r1 = Math.max(0,i - k);
                int c1 = Math.max(0,j - k);
                int r2 = Math.min(m-1,i + k);
                int c2 = Math.min(n-1,j + k);
                
                res[i][j] = dp[r1][c1] + dp[r2+1][c2+1] - dp[r1][c2+1] - dp[r2+1][c1];
            }
        }
        
        return res;
    }
}
