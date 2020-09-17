package com.company;
// Question link : https://www.geeksforgeeks.org/count-ways-divide-circle-using-n-non-intersecting-chords/

import java.util.Arrays;

// Question desc : number of ways to divide circle into N non-intersecting chords if total points are 2*N
public class count_ways_divide_circle_N_non_intersecting_chords
{
    public static void main(String[] args) {
        int n = 4;

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        int res = divideCircleIntoNChords(n,dp);
        System.out.println(res);
    }

    public static int divideCircleIntoNChords(int n,int []dp)
    {
        if (n <= 1)
            return 1;

        if (dp[n]!=-1)
            return dp[n];

        int count = 0;
        for (int i=0;i<n;i++)
        {
            count += divideCircleIntoNChords(i,dp)*divideCircleIntoNChords(n-i-1,dp);
        }
        return dp[n] = count;
    }
}
