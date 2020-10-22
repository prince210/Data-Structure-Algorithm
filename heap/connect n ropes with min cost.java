package com.company;

import java.util.PriorityQueue;

public class connect_n_ropes_min_cost_imp
{

    // The brute of this solution is to get permutation of array and get minSum among all the permuted array
    public static void main(String[] args) {
        int[] arr = {4,3,2,6};

        minCost(arr);
    }

    // Time - O(nlogn)      space - O(n)
    public static void minCost(int[] arr)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0;i<arr.length;i++)
        {
            pq.add(arr[i]);
        }

        System.out.println(pq);
        int n = arr.length;
        int sum = 0;
        int minSum = 0;
        for (int i = 0;i<n-1;i++)
        {
            int first = pq.poll();
            int second = pq.poll();

            sum = first+second;
            minSum += sum;

            pq.add(sum);
        }

        System.out.println(minSum);
    }
}
