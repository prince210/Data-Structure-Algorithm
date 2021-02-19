// question Link : https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

// Functional Problem 

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) 
    {
        int max_so_far = 0;
        int maxEnded = Integer.MIN_VALUE;
        
        int n = A.length;
        for(int i = 0;i < n;i++)
        {
            max_so_far += A[i];
            
            if (maxEnded < max_so_far)
            {
                maxEnded = max_so_far;
            }
            
            if(max_so_far < 0)
            {
                max_so_far = 0;
            }
        }
        
        return maxEnded;
    }
}

//       |
// -1, -2, 3, 4, -10

// maxSum = 10
