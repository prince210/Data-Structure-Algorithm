import java.util.Collections;
import java.util.PriorityQueue;

public class kth_largest_sum_contigous_subarr
{
    public static void main(String[] args) {
        int[] arr = {10, -10, 20, -40};
        int k = 6 ;

        findKthMax(arr,k);
    }

    // NOT GOOD APPROACH
    // Time - O(n^2*log(n))             space - O(n^2)
    public static void findKthMax(int[] arr,int K)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        int[][] sumArr = new int[n][n];
        for (int k = 0;k < arr.length;k++)
        {
            for (int i = 0;i < arr.length-k;i++)
            {
                int j = i+k;
                if (k == 0)
                {
                    sumArr[i][j] = arr[i];
                }
                else
                {
                    sumArr[i][j] = sumArr[i][j-1]
                            +sumArr[j][j];
                }
            }
        }

        for (int i = 0;i < arr.length;i++)
        {
            for (int j = 0;j < arr.length;j++)
            {
                System.out.print(sumArr[i][j]+" ");
                if(sumArr[i][j]!=0)
                {
                    pq.add(sumArr[i][j]);
                }
            }
            System.out.println();
        }
        int i = 1;
        while (i<K)
        {
            pq.poll();
            i++;
        }

        System.out.println(pq.poll());
    }
}
