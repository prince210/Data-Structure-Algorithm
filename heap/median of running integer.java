package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class median_of_running_integers_most_imp_in_heaps // running integers means on every iteration calculate median
{
    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        // Approach 1
        medianUsingHeaps(arr);

        // Approach 2
        medianUsingInsertionSort(arr);
    }

    // Time - O(n^2)                 space - O(1)
    public static void medianUsingInsertionSort(int[] arr)
    {
        // sorting is done because median is always done on sorted part of array
        System.out.print(arr[0]+" ");
        for (int i = 1;i<arr.length;i++)
        {
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

            if ((i+1)%2 == 0)
            {
                int median = (arr[((i+1)/2)-1]+arr[((i+1)/2+1)-1])/2;
                System.out.print(median+" ");
            }
            else
            {
                int median = arr[(i+1)/2];
                System.out.print(median+" ");
            }
        }
        System.out.println();
    }

    // *********** MOST IMP *****************
    // Time - O(nlogn)              space - O(n)
    public static void medianUsingHeaps(int[] arr)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for (int i = 0;i<arr.length;i++) // pass integer one by one
        {
            if (maxHeap.isEmpty() || maxHeap.peek()>=arr[i])
            {
                maxHeap.add(arr[i]);
            }
            else
            {
                minHeap.add(arr[i]);
            }
            // adjust size as both the priority queue contains almost same size
            if (maxHeap.size()>minHeap.size()+1)
            {
                minHeap.add(maxHeap.peek());
                maxHeap.poll();
            }
            else if (minHeap.size()>maxHeap.size()+1)
            {
                maxHeap.add(minHeap.peek());
                minHeap.poll();
            }

            // if size of both the heaps is even then median is Mean(maxHeap.top(),minHeap.top())
            int size = maxHeap.size()+minHeap.size();
            if (size%2 == 0)
            {
               int median = (maxHeap.peek()+minHeap.peek())/2;
                System.out.print(median+" ");
            }
            else // if size of both heap is odd the median is top of which ever heap size is maximum
            {
                int median = 0;
                if (maxHeap.size()>minHeap.size())
                {
                    median = maxHeap.peek();
                }
                else // equal case would not come because if size of both heap is equal then it will not come in else part(in odd case)
                {
                    median = minHeap.peek();
                }

                System.out.print(median+" ");
            }
        }
        System.out.println();
    }
}
