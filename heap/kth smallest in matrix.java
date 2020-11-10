// Question Link : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length == 0 || k < 0 || k > matrix.length * matrix.length)
        {
            return 0;
        }
        
        return findkthSmallest(matrix,k);
    }
    
    public int findkthSmallest(int[][] matrix,int k)
    {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int midLoc = findLoc(matrix,mid);
            if(midLoc < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
    
    public int findLoc(int[][] matrix,int x)
    {
        int n = matrix.length;
        int i = 0;
        int j = n-1;
        
        int pos = 0;
        while((i >= 0 && i < n) && (j >= 0 && j < n))
        {
            if(matrix[i][j] > x)
            {
                j--;
            }
            else
            {
                pos += j+1;
                i++;
            }
        }
        return pos;
    }
}


// heap based solution
class Node
{
    int i;
    int j;
    int val;
    Node(int i,int j,int val)
    {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}

class heapSol {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1,Node n2)
            {
                return n1.val - n2.val;
            }
        });
        
        int n = matrix.length;
        for(int i = 0;i < n;i++)
        {
            pq.add(new Node(i,0,matrix[i][0]));
        }
        
        while(!pq.isEmpty() && k-- > 1)
        {
            Node temp = pq.poll();
            // System.out.println(temp.val);
            if(temp.j >= n-1)
                continue;
            
            pq.add(new Node(temp.i,temp.j+1,matrix[temp.i][temp.j+1]));
        }
        return pq.isEmpty()?-1:pq.poll().val;
    }
}
