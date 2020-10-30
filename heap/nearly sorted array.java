import java.util.PriorityQueue;


// commonly asked ------------------------------------->
public class nearly_sorted_array_k_sorted_array_very_imp
{
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3; // array is k sorted that means every element is k shifted from its path

        nearlySorted(arr,k);
    }

    // Time - O(nlogk)                  space - O(k)
    public static void nearlySorted(int[] arr,int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = arr.length;
        for (int i = 0;i <= k;i++)
        {
            pq.add(arr[i]);
        }

        int index = 0;
        for (int i = k+1;i < n;i++)
        {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while (!pq.isEmpty())
        {
            arr[index++] = pq.poll();
        }


        for (int i = 0;i < n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
