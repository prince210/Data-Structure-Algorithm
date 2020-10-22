package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class merge_two_binary_max_heaps
{
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 6, 2};
        int[] arr2 = {12, 7, 9};

        mergeHeaps(arr1,arr2);
    }

    public static void mergeHeaps(int[] arr1,int[] arr2)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0;i<arr1.length;i++)
        {
            pq.add(arr1[i]);
        }

        for (int j = 0;j<arr2.length;j++)
        {
            pq.add(arr2[j]);
        }

        System.out.println(pq);
    }
}
