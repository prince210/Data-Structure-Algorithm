// Functional Problem
// question desc : https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1#

class MaxDifference{

    // arr[]: input array
    // n: size of array
    // Function to find the maximum index difference.

static int maxIndexDiff(int arr[], int n) {
        int[] leftMin = new int[n];
        leftMin[0] = arr[0];
        
        for(int i = 1;i < n;i++)
        {
            leftMin[i] = Math.min(arr[i],leftMin[i-1]);
        }
        
        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
        
        for(int i = n-2;i >= 0;i--)
        {
            rightMax[i] = Math.max(arr[i],rightMax[i+1]);
        }
        
        int i = 0;
        int j = 0;
        int maxDiff = -1;
        while(i < n && j < n)
        {
            if(leftMin[i] <= rightMax[j])
            {
                maxDiff = Math.max(maxDiff,j - i);
                j++;
            }
            else
            {
                i++;
            }
        }
        
        return maxDiff;
    }
}
