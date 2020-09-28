// Question Link : 

import java.util.Arrays;
import java.util.Comparator;


// very imp ------------------>
// ---------------------------> Very Tricky ---------------------->
class Box
{
    int length,width,height;
    Box(int length,int width,int height)
    {
        this.height = height;
        this.length = length;
        this.width = width;
    }
}

public class box_stacking_very_imp_DP
{
    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4,6,7);
        arr[1] = new Box(1,2,3);
        arr[2] = new Box(4,5,6);
        arr[3] = new Box(10,12,32);

//        arr[0] = new Box(1,2,4);
//        arr[1] = new Box(3,2,5);

        stackBoxMaxHeight(arr);
    }

    public static void stackBoxMaxHeight(Box[] arr)
    {
        // Step 1 - // we can rotate boxes to get different combinations

        // Step 2 -
        // To stack a box we need to satisfy two conditions
        // 1.) base area (length * width) of upper block < base area(length * width) of lower block
        // 2.) height of upper block < height of lower block

        int n = arr.length;
        Box[] combinations = new Box[n*3];

        int count = 0;
        for (int i = 0;i < n;i++)
        {
            int h = arr[i].height;
            int w = arr[i].width;
            int l = arr[i].length;

            // below 3 statements are to satisfy the condition 1
            combinations[count++] = rotations(l,w,h);
            combinations[count++] = rotations(w,l,h);
            combinations[count++] = rotations(h,l,w);
        }

        // to satisfy condition 1 we need to sort the array according to base area
        Arrays.sort(combinations, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.length*o2.width - o1.length*o1.width ;
            }
        });

        for (int i = 0;i < 3*n;i++)
        {
            System.out.println(combinations[i].length+" "+combinations[i].width+" "+combinations[i].height);
        }
        System.out.println();

        int maxHeight = Integer.MIN_VALUE;
        int[] dp = new int[3*n];

        for (int i = 0;i < 3*n;i++)
        {
            dp[i] = combinations[i].height;
        }
        for (int i = 1;i < 3*n;i++)
        {
            for (int j = i-1;j>=0;j--)
            {
                if (combinations[i].length < combinations[j].length && combinations[i].width < combinations[j].width)
                {
                    dp[i] = Math.max(dp[i],
                            dp[j]+combinations[i].height);
                }
            }
            maxHeight = Math.max(dp[i],maxHeight);
        }

        for (int i = 0;i < 3*n;i++)
        {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        System.out.println(maxHeight);
    }

    // we have assumption that length >= width
    public static Box rotations(int height,int ele1,int ele2)
    {
        int h = height;
        int l;
        int w;
        if (ele1 >= ele2)
        {
            l = ele1;
            w = ele2;
        }
        else
        {
            l = ele2;
            w = ele1;
        }

        Box newBox = new Box(l,w,h);
        return newBox;
    }
}
