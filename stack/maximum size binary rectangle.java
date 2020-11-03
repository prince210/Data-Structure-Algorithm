package com.company;

import java.util.Stack;

public class maximum_size_rectangle_binary_matrix
{
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};

        maximumRectArea(arr);
    }

    // Time - O(N^2)                // space - O(1)
    public static void maximumRectArea(int[][] arr)
    {
        int area = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[0].length;j++)
            {
                if (arr[i][j] == 1 && i!=0)
                 arr[i][j] += arr[i-1][j];
            }
            area = Math.max(area,max_Area_Rectangle_InOneD_Histogram(arr[i]));
        }
        System.out.println(area);
    }

    public static int max_Area_Rectangle_InOneD_Histogram(int[] arr)
    {
        int n = arr.length;
        int[] nearestSmallerLeft = new int[n];
        int[] nearestSmallerRight = new int[n];

        NSL(arr,nearestSmallerLeft); // nearest smaller in left side of array
        NSR(arr,nearestSmallerRight); //nearest smaller in right side of array

        int area = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            area = Math.max(area,arr[i] * (nearestSmallerRight[i] - nearestSmallerLeft[i] - 1));
        }
        System.out.println(area);
        return area;
    }

    public static void NSL(int[] arr,int []nearestSmallerLeft)
    {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++)
        {
            if (stack.size() == 0)
            {
                stack.push(i);
                nearestSmallerLeft[i] = -1;
            }
            else
            {
                while (stack.size()>0 && arr[stack.peek()]>=arr[i])
                {
                    stack.pop();
                }
                if (stack.size() == 0)
                {
                    nearestSmallerLeft[i] = -1;
                }
                else
                {
                    nearestSmallerLeft[i] = stack.peek();
                }
                stack.push(i);
            }
        }
    }

    public static void NSR(int[] arr,int []nearestSmallerRight)
    {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1;i>=0;i--)
        {
            if (stack.size() == 0)
            {
                stack.push(i);
                nearestSmallerRight[i] = n;
            }
            else
            {
                while (stack.size()>0 && arr[stack.peek()]>=arr[i])
                    stack.pop();
                if (stack.size() == 0)
                {
                    nearestSmallerRight[i] = n;
                }
                else
                {
                    nearestSmallerRight[i] = stack.peek();
                }
                stack.push(i);
            }
        }
    }
}
