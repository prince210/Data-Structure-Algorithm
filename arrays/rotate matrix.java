// problem link : 

// // problem description : 

// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// You need to do this in place.

// Note that if you end up using an additional array, you will only receive partial score.

// Example:

// If the array is

// [
//     [1, 2],
//     [3, 4]
// ]
// Then the rotated array becomes:

// [
//     [3, 1],
//     [4, 2]
// ]


public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) 
    {
        int n = a.size();
        for(int i = 0;i < n;i++)
        {
            for(int j = i;j < n-i-1;j++)
            {
                int temp = a.get(i).get(j);
                a.get(i).set(j,a.get(n-j-1).get(i));
                a.get(n-j-1).set(i,a.get(n-i-1).get(n-j-1));
                a.get(n-i-1).set(n-j-1,a.get(j).get(n-i-1));
                a.get(j).set(n-i-1,temp);
            }
        }
    }
}
