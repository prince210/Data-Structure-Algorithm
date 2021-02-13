public class vimp_rearrange_array_alternatively_pos_neg
{
    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

//        rearrangeUsingSpace(arr);
//        rearrWithoutSpaceOrderChg(arr);
        rearrWithoutSpaceOrderPreserved(arr);
    }

    // Time - O(n)          space - O(1)
    public static void rearrangeUsingSpace(int[] arr)
    {
        int n = arr.length;
        Integer[] neg = new Integer[n];
        Integer[] pos = new Integer[n];

        int p = 0;
        int q = 0;
        for (int i = 0;i < n;i++)
        {
            if (arr[i] < 0)
            {
                neg[p++] = arr[i];
            }
            else
            {
                pos[q++] = arr[i];
            }
        }

        int k = 0;
        int l = 0,m = 0;
        while (k < n)
        {
            if (l < p)
            {
                arr[k++] = neg[l++];
            }
            if (m < q)
            {
                arr[k++] = pos[m++];
            }
        }

        for (int i = 0;i < arr.length;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // Time - O(n)                      space - O(1)
    public static void rearrWithoutSpaceOrderPreserved(int[] arr)
    {
        int wrongInd = -1;
        for (int i = 0;i < arr.length;i++)
        {
            if (wrongInd == -1)
            {
                if (((i % 2 == 0) && arr[i] >= 0) || ((i % 2 == 1) && arr[i] < 0))
                {
                    wrongInd = i;
                }
            }
            else
            {
                if ((arr[wrongInd] >= 0 && arr[i] < 0) ||(arr[wrongInd] < 0 && arr[i] >= 0))
                {
                    rightRot(arr,wrongInd,i);

                    if (i - wrongInd >= 2)
                    {
                        wrongInd += 2;
                    }
                    else
                    {
                        wrongInd = -1;
                    }
                }
            }
        }

        for (int i = 0;i < arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void rightRot(int[] arr,int start,int end)
    {
        int temp = arr[end];
        for (int i = end;i > start;i--)
        {
            arr[i] = arr[i-1];
        }
        arr[start] = temp;
    }


    // It is a solution when order of elements does not matter [not this question]
    // Time - O(n)          space - O(1)
    public static void rearrWithoutSpaceOrderChg(int []arr)
    {
        // Two steps are involved
        // First take all positive to left side and take all negative to right side
        // Second for every negative swap with positive and increment negative by 1 while increment positive by 2

        // {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
        int i = 0;
        int j = arr.length - 1;

        while (i <= j)
        {
            if (arr[i] >= 0 && arr[j] < 0)
            {
                i++;
                j--;
            }
            else if (arr[i] >= 0 && arr[j] >= 0)
            {
                i++;
            }
            else if(arr[i] < 0 && arr[j] >= 0)
            {
                swap(arr,i,j);
                i++;
                j--;
            }
            else
            {
                j--;
            }
        }

        int k = 0;
        while (i < arr.length && k < arr.length)
        {
            swap(arr,i,k);
            i++;
            k += 2;
        }

        for (int p = 0;p < arr.length;p++)
        {
            System.out.print(arr[p] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
