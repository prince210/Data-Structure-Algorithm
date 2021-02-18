// Question Desc : https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Functional Problem

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int n = nums.length;
        for(int i = 0;i < n;i++)
        {
            int j = Math.abs(nums[i])-1;
            if(nums[j] >= 0)
            {
                nums[j] = -nums[j];
            }
            else
            {
                res.add(j+1);
            }
        }
        
        return res;
    }
}

//              |
// 4 -3 -2 -7 8 2 -3 -1

// 0  1  2  3 4 5  6  7 
