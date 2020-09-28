// Question Link : https://www.geeksforgeeks.org/dynamic-programming-building-bridges/

import java.util.Arrays;
import java.util.Comparator;

public class very_tricky_max_non_overlapping_bridge
{
    public static void main(String[] args) {
        int[] northBank = {8,1,4,3,5,2,6,7};
        int[] southBank = {1,2,3,4,5,6,7,8};

        maxNonOverLap(northBank,southBank);
    }

    // Time - O(nlogn + n^2)                space - O(n)
    public static void maxNonOverLap(int[] northBank,int []southBank)
    {

        // step 1 : sort on basis of north bank because we are having condition that bridges doesn't overlap
        // such that (ith of northBank > jth of northBank) and (ith of southBank > jth of southBank)
        // by sorting northBank we reduce the one condition i.e. (ith of northBank > jth of northBank) will always true
        // now we only have to care about (ith of southBank > jth of southBank)

        // step 2 : Apply LIS by condition of southbank i.e (ith of southBank > jth of southBank)
        int n = northBank.length;
        int[][] combined = new int[n][2];

        for (int i = 0;i < n;i++)
        {
            combined[i][0] = northBank[i];
            combined[i][1] = southBank[i];
        }

        Arrays.sort(combined, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0;i < n;i++)
        {
            System.out.println(combined[i][0]+" "+combined[i][1]);
        }
        System.out.println();


        int[] dp = new int[n];
        // every bridge is non - overlapping so it is a solution in itself so fill dp with 1
        Arrays.fill(dp,1);

        int maxBridges = -1;
        for (int i = 1;i < n;i++)
        {
            for (int j = i-1;j>=0;j--)
            {
                if (combined[i][1] > combined[j][1])
                {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxBridges = Math.max(maxBridges,dp[i]);
        }

        for (int i = 0;i < n;i++)
        {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        System.out.println(maxBridges);
    }
}
