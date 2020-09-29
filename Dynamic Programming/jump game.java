// Question Link : https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class pair
{
    int index;
    int jumps;
    String path;

    pair(int index,int jumps,String path)
    {
        this.index = index;
        this.jumps = jumps;
        this.path = path;
    }
}

public class minimum_jumps_to_reach_end
{
    public static void main(String[] args) {
//        int[] arr = {1,3,5,8,9,2,6,7,6,8,9};

//        int[] arr = {1,5,4,2,9,8,6};

//        int[] arr = {1,5,0,4,2,8};

//        int[] arr= {1,3,6,1,0,9};

        int []arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        MinJump(arr);
    }

    public static void MinJump(int[] arr)
    {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[arr.length - 1] = 0;
        for (int i=arr.length-2;i>=0;i--)
        {
            int steps = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j=1;(j<=steps) && (j+i < arr.length);j++)
            {
                if (dp[j+i] != Integer.MAX_VALUE && dp[i+j] < min)
                {
                    min = dp[i+j];
                }
            }
            if (min != Integer.MAX_VALUE)
            {
                dp[i] = min+1;
            }
        }

        for (int i=0;i<dp.length;i++)
        {
            System.out.print(dp[i]+" ");
        }
        System.out.println();

        // printing the path -----------> Important *(asked in amazon) ------------->
        pair initial = new pair(0,dp[0],0+"");
        Queue<pair> queue = new LinkedList<>();
        queue.add(initial);

        while (!queue.isEmpty())
        {
            pair temp = queue.poll();

            if (temp.jumps == 0)
            {
                System.out.println(temp.path);
            }
            for (int j = 1;j <= arr[temp.index];j++)
            {
                if (temp.index + j < arr.length && dp[temp.index+j]!=Integer.MAX_VALUE
                    && temp.jumps-1 == dp[temp.index+j])
                {
                    queue.add(new pair(temp.index+j,temp.jumps-1,temp.path+"->"+(temp.index+j)));
                }
            }
        }
    }
}
