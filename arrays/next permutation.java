// question link : https://www.interviewbit.com/problems/next-permutation/
// Functional problem

public class Solution {
    public int[] nextPermutation(int[] A) 
    {
        int n = A.length;
        int i = n - 2;
        
        while(i >= 0 && A[i] >= A[i+1])
        {
            i--;
        }
        
        if(i >= 0)
        {
            int j = n-1;
            while(A[j] <= A[i])
            {
                j--;
            }
            swap(A,i,j);
        }
        
        reverse(A,i+1,n-1);
        
        return A;
    }
    
    public void reverse(int []arr,int i,int j)
    {
        while(i < j)
        {
            swap(arr,i++,j--);
        }
    }
    
    public void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // [2,1,3] --> [2,3,1]
}
