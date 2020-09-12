// question link : https://www.geeksforgeeks.org/coin-change-dp-7/

// question desc : Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
// how many ways can we make the change if order of coins doesn’t matter.
// For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
// For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

// code : 

import java.util.ArrayList;
import java.util.Collections;

public class coin_change
{
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int amount = 11;

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        printComb(arr,amount,new ArrayList<Integer>(),0,arrayLists);
        System.out.println(arrayLists);

        maxWays(arr,amount);
    }

    public static void printComb(int []arr,int amount,ArrayList<Integer> temp,int ways,ArrayList<ArrayList<Integer>> arrayLists)
    {
        if (amount<0)
            return;

        if (amount == 0)
        {
            ArrayList<Integer> ar = new ArrayList<>(temp);
            Collections.sort(ar);
            if (!arrayLists.contains(ar))
            {
                arrayLists.add(new ArrayList<>(temp));
            }
            return;
        }


        for (int i=0;i<arr.length;i++)
        {
            temp.add(arr[i]);
            printComb(arr,amount-arr[i],temp,ways+1,arrayLists);
            temp.remove(temp.size()-1);
        }
    }

    public static void maxWays(int[] arr,int amount)
    {
        int[][] dp = new int[arr.length+1][amount+1];
        for (int i=1;i<=arr.length;i++)
        {
            dp[i][0] = 1;
        }

        for (int i=1;i<=amount;i++)
        {
            dp[0][i] = 0;
        }

        for (int i=1;i<=arr.length;i++)
        {
            for (int j=1;j<=amount;j++)
            {
                if (arr[i-1]<=j)
                {
                    dp[i][j] = dp[i][j-arr[i-1]]+dp[i-1][j];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[arr.length][amount]);
    }
}
