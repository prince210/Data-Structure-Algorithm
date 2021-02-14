// functional code 
// problem link : https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1#

class TripletSum
{
    public static int find3Numbers(int arr[], int N, int sum) { 
        for (int i = 0; i < N - 1; i++) { 
            HashSet<Integer> s = new HashSet<>(); 
            for (int j = i + 1; j < N; j++) { 
                int x = sum - (arr[i] + arr[j]); 
                if (s.contains(x)) 
                    return 1; 
                else
                    s.add(arr[j]); 
            } 
        } 
        return 0;
    }
}
