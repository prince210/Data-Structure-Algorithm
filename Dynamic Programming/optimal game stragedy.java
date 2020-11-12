// question link : https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1

class solve{
    static long countMaximum(int arr[], int n){
        long [][]dp = new long[n][n];
        
        for(int i = 0;i < n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        long res = maxCoins(arr,0,arr.length-1,dp);
        return res;
    }
    
    static long maxCoins(int[] arr,int i,int j,long[][] dp)
    {
        if(i >= j || i >= arr.length || j < 0)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];
            
        
        return dp[i][j] = Math.max(arr[i] + Math.min(maxCoins(arr,i+2,j,dp),maxCoins(arr,i+1,j-1,dp)),
                                    arr[j] + Math.min(maxCoins(arr,i+1,j-1,dp),maxCoins(arr,i,j-2,dp)));
    }
}
