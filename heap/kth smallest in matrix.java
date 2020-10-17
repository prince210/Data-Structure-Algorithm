// Question Link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || k < 0 || k > matrix.length * matrix.length)
        {
            return 0;
        }
        
        return findkthSmallest(matrix,k);
    }
    
    public int findkthSmallest(int[][] matrix,int k)
    {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int midLoc = findLoc(matrix,mid);
            if(midLoc < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
    
    public int findLoc(int[][] matrix,int x)
    {
        int n = matrix.length;
        int i = 0;
        int j = n-1;
        
        int pos = 0;
        while((i >= 0 && i < n) && (j >= 0 && j < n))
        {
            if(matrix[i][j] > x)
            {
                j--;
            }
            else
            {
                pos += j+1;
                i++;
            }
        }
        return pos;
    }
}
