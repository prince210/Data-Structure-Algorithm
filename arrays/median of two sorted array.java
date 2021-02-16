// Functional Problem 
// Question Link : https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0.0;
        if (nums1.length > nums2.length) 
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        if(nums1.length <= nums2.length)
        {
            int low = 0;
            int high = nums1.length;
            while(low <= high)
            {
                int partitionX = low + (high - low)/2;
                int partitionY = (nums1.length + nums2.length + 1)/2 - (partitionX);

                int maxLeft1 = partitionX == 0?Integer.MIN_VALUE:nums1[partitionX - 1];
                int minRight1 = partitionX == nums1.length?Integer.MAX_VALUE:nums1[partitionX];

                int maxLeft2 = partitionY == 0?Integer.MIN_VALUE:nums2[partitionY - 1];
                int minRight2 = partitionY == nums2.length?Integer.MAX_VALUE:nums2[partitionY];

                if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
                {
                    if((nums1.length + nums2.length) % 2 == 0)
                    {
                        return (double)(Math.max(maxLeft1,maxLeft2) + Math.min(minRight1,minRight2))/2;
                    }
                    else
                    {
                        return (double)Math.max(maxLeft1,maxLeft2);
                    }
                }
                else if(maxLeft1 > minRight2)
                {

                    high = partitionX - 1;
                }
                else
                {
                    low = partitionX + 1;
                }
            }
        }
        return median;
    }
}
