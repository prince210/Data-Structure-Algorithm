// functional problem 
// problem link : https://www.interviewbit.com/problems/first-missing-integer/

// problem desc : 
// Given an unsorted integer array, find the first missing positive integer.
// Example:

// Given [1,2,0] return 3,

// [3,4,-1,1] return 2,

// [-8, -7, -6] returns 1

// Your algorithm should run in O(n) time and use constant space.

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) 
    {
        if(A == null || A.size() == 0)
            return 1;
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < A.size();i++)
        {
            hs.add(A.get(i));
        }
        
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        
        for(int ele : hs)
        {
            if(ele > 0)
            {
                min = Math.min(min,ele);
                if(!hs.contains(ele + 1) && ele != 2147483647)
                {
                    res = Math.min(res,ele + 1);
                }
            }
        }
        
        if(min != 1)
            return 1;
        
        return res;
    }
}
