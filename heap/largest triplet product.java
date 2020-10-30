import java.util.Collections;
import java.util.PriorityQueue;

public class largest_triplet_product
{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        findLargestTripletProdInRunningStream(arr);
    }

    public static void findLargestTripletProdInRunningStream(int[] arr)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());// max heap pq
        for (int i = 0;i<arr.length;i++)
        {
            if (i<2)
            {
                System.out.print((-1)+" ");
                pq.add(arr[i]);
            }
            else
            {
                int prod = 1;
                int count = 0;
                int[] sizeThreeArr = new int[3];
                pq.add(arr[i]);
                while (pq.size()>0 && count<3)
                {
                    prod *= pq.peek();
                    sizeThreeArr[count] = pq.poll();
                    count++;
                }

                for (int j=0;j<3;j++)
                {
//                    System.out.println(sizeThreeArr[j]);
                    pq.add(sizeThreeArr[j]);
//                    sizeThreeArr[j] = 0;
                }
//                System.out.println();
                System.out.print(prod+" ");
            }
        }
        System.out.println();
    }
}
