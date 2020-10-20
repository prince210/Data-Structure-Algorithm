package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;


// Nice Question-------------> Important ---------------------->
public class merge_overlapping
{
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{5,71},{15,17},{16,18}};

        mergeIntervals(intervals);
    }

    public static void mergeIntervals(int[][] intervals)
    {
        int row = intervals[0].length-1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if (o1[row-1]>o2[row-1])
//                    return 1;
//                else
//                    return -1;
                return o1[0] - o2[0];
            }
        });

//        for (int i=0;i<intervals.length;i++)
//        {
//            for (int j=0;j<2;j++)
//            {
//                System.out.print(intervals[i][j]+" ");
//            }
//            System.out.println();
//        }

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i=1;i<intervals.length;i++)
        {
            int[] temp = stack.peek();

            if (intervals[i][0]<= temp[1]) //overlapping
            {
                stack.pop();
                temp[1] = intervals[i][1]>temp[1]?intervals[i][1]:temp[1];
                stack.push(temp);
            }
            else //non - overlapping
            {
                stack.push(intervals[i]);
            }
        }

        Stack<int[]> result = new Stack<>(); // we want result in ascending order
        int size = stack.size();
        for (int i=0;i<size;i++)
        {
            result.push(stack.pop());
        }

        for (int i=0;i<size;i++)
        {
            int[] temp = result.pop();
            System.out.println(temp[0]+" "+temp[1]);
        }
        System.out.println();
    }
}
