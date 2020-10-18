import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class max_heap_implementation
{
    public static void main(String[] args) {
//        int[] arr = {10,20,15,12,40,25,18}; //convert arr to Max - heap and then perform sorting

        int[] arr = {7,10,4,3,20,15};

        usingPriorityQueue(arr);

        constructMaxHeap(arr);

    }

    // Time - O(n+nlogn) // n for construction and nlogn for heapify for n elements
    public static void constructMaxHeap(int[] arr)
    {
        int n = arr.length;
        for (int i = n/2-1;i>=0;i--)
        {
            Heapify(i,n,arr); // To construct binary tree and
        }

        for (int i = 0;i < n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        // performing heap sort
        for (int i = n-1;i>=0;i--)
        {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;

            Heapify(0,i,arr);
        }

        for (int i = 0;i < n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void Heapify(int index,int n,int []arr)
    {
        int left = 2*index+1;
        int right = 2*index+2;
        int largest = index;
        if (left<n && arr[left]>arr[largest])
        {
            largest = left;
        }

        if (right<n && arr[right]>arr[largest])
        {
            largest = right;
        }

        if (largest!=index)
        {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;

            Heapify(largest,n,arr);
        }
    }

    public static void usingPriorityQueue(int[] arr)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i =0 ;i<arr.length;i++)
        {
            pq.add(arr[i]);
        }

        while (!pq.isEmpty())
        {
            System.out.print(pq.peek()+" ");
            pq.poll();
        }
        System.out.println();
    }
}
