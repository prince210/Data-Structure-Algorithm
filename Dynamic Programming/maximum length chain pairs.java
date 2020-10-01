package com.company;

import java.util.Arrays;

public class maximum_length_chain_pairs
{
    public static void main(String[] args) {
        int [][]pairs = new int[][]{{5,24},
                {39,60},
                {15,28},
                {27,40},
                {50,90}};

//        int [][]pairs = {{3,4},
//                {7,8},
//                {5,6}};

        // use comparator to sort 
        // just tried this with bubble sort
        // so we sort it
        int []temp = new int[2];
        for (int i=0;i<pairs.length;i++)
        {
            for(int j=i+1;j<pairs.length;j++)
            {
                if (pairs[i][0]>pairs[j][1])
                {
                    temp[0] = pairs[i][0];
                    temp[1] = pairs[i][1];

                    pairs[i][0] = pairs[j][0];
                    pairs[i][1] = pairs[j][1];

                    pairs[j][0] = temp[0];
                    pairs[j][1] = temp[1];
                }
            }
        }

        maximumLen(pairs);
    }

    public static void maximumLen(int[][] pairs)
    {
        int[] arr = new int[pairs.length*2];

        int count = 0;
        for (int i=0;i<pairs.length;i++)
        {
            arr[count] = pairs[i][0];
            arr[count+1] = pairs[i][1];
            count+=2;
        }

        for (int ele:arr)
        {
            System.out.print(ele+" ");
        }
        System.out.println();
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);

        int max = Integer.MIN_VALUE;

        for (int i=1;i<arr.length;i++)
        {
            for (int j=i-1;j>=0;j--)
            {
                if (arr[i]>arr[j])
                   dp[i] = Math.max(dp[i],dp[j]+1);
            }

            max = Math.max(max,dp[i]);
        }

        System.out.println(max/2);
    }
}
