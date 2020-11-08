package com.company;


// very interesting question -------->
// very important question ---------->
public class rain_water_tapping_imp_interesting
{
    public static void main(String[] args) {
     int[] arr = {7, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 5}; // elevation map that is given structure for water like this where the width of each bar is 1.

        findAmountWaterStored(arr);
        getWaterStoredAmount(arr);
    }

    // Time - O(n^2)        space - O(1)
    public static void findAmountWaterStored(int[] arr)
    {
        int n = arr.length;
        int area = 0;
        for (int i=0;i<n;i++)
        {
            // To get the amount of water stored we need to know the boundary and height of current level
            // we can get boundary by maximum height of building on left side for current i and maximum height of building on right side for current i
            // then minimum of (leftmax,rightmax) is boundary of building
            // height of current level is arr[i]

            // maximum height on left side
            int leftMax = arr[i];
            for (int j=0;j<i;j++)
            {
                leftMax = Math.max(leftMax,arr[j]);
            }

            // maximum height on right side
            int rightMax = arr[i];
            for (int j=i+1;j<n;j++)
            {
                rightMax = Math.max(rightMax,arr[j]);
            }

            area += Math.min(leftMax,rightMax)-arr[i];
        }

        System.out.println(area);
    }


    // Time - O(n)      space - O(n)
    public static void getWaterStoredAmount(int[] arr)
    {
        int n = arr.length;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];

        int left = 0;
        for (int i=0;i<n;i++)
        {
            left = Math.max(left,arr[i]);
            leftArr[i] = left;
        }

        int right = 0;
        for (int i=n-1;i>=0;i--) {
            right = Math.max(right, arr[i]);
            rightArr[i] = right;
        }

        int area = 0;
        for(int i=0;i<n;i++)
        {
            area += Math.min(leftArr[i],rightArr[i])-arr[i];
        }
        System.out.println(area);
    }
}
