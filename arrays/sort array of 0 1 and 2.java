import java.util.ArrayList;

public class sort_arr_0_1_2
{
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortArr(arr);
        dutchNationalFlag(arr);
    }

    // Time - O(n)          space - O(3n) == O(n)
    public static void sortArr(int[] arr)
    {
        ArrayList<Integer> zero = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        for (int i=0;i<arr.length;i++)
        {
            if (arr[i] == 0)
                zero.add(0);
            else if (arr[i] == 1)
                one.add(1);
            else if (arr[i] == 2)
                two.add(2);
        }

        for (int i=0;i<one.size();i++)
        {
            zero.add(one.get(i));
        }
        for (int i=0;i<two.size();i++)
        {
            zero.add(two.get(i));
        }
        System.out.println(zero);
    }

    // Time - O(n)      space - O(1)
    public static void dutchNationalFlag(int []arr)
    {
        int l = 0;
        int h = arr.length-1;
        int m = 0; // it will traverse the whole arr

        while (m<=h)
        {
            if (arr[m] == 0) // case 1
            {
                swap(arr,m,l);
                m++;
                l++;
            }
            else if (arr[m] == 1) // case 2
            {
                m++;
            }
            else if (arr[m] == 2) // case 3
            {
                swap(arr,m,h);
                h--;
                // here we haven't increased m, because see the below example,
//                l
//                0  0  1  2  1  1  1  1  2
//                         m              h

                // lets run the algorithm for m++ and h--
                // again run algorithm with only h-- and observe which one yield corrects ans
            }
        }

        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void swap(int []arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
