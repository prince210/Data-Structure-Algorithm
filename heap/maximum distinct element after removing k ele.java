package com.company;

import java.util.*;


// Good Question ------------------------------>
public class maximum_distinct_element_after_removing_k_ele {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2};
        int k = 1;

        maximumDistinct(arr,k);
    }

    // Time - O(nlogd)                       space - O(n)
    public static void maximumDistinct(int[] arr,int k)
    {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i =0;i<arr.length;i++)
        {
            if (!freq.containsKey(arr[i]))
            {
                freq.put(arr[i],1);
            }
            else
            {
                int x = freq.get(arr[i]);
                x++;
                freq.replace(arr[i],x);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // using max heap
        for (int ele : freq.values())
        {
            pq.add(ele);
        }

        while (k>0)
        {
            int a = pq.poll();
            a--;
            if (a>0)
            {
                pq.add(a);
            }
            k--;
        }

        int uniqueCount = 0;
        for (int i = 0;i < pq.size();i++)
        {
            if (pq.peek()>0)
            {
                uniqueCount++;
            }
        }
        System.out.println(uniqueCount);
    }
}
