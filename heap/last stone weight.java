class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones)
            pq.add(ele);
        
        while(pq.size() > 1)
        {
            int y = pq.poll();
            int x = pq.poll();
            
            if(y > x && y != x)
            {
                pq.add(y-x);
            }
        }
        
        if(pq.size() == 1)
        {
            return pq.poll();
        }
        return 0;
    }
}
