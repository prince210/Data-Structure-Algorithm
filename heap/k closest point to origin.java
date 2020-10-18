class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0)
            return new int[][]{{}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
                                                          {
                                                              public int compare(int[] o1,int[] o2)
                                                              {
                                                                  return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0] + o2[1]*o2[1]);
                                                              }
                                                          });
        int n = points.length;
        for(int i = 0;i < n;i++)
        {
            pq.add(points[i]);
        }
        
        int[][] op = new int[k][2];
        for(int i = 0;i < k;i++)
        {
            op[i] = pq.poll();
        }
        return op;
    }
}
