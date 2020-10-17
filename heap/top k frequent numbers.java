// Question Link : https://leetcode.com/problems/top-k-frequent-elements/

class Node
{
    int key;
    int freq;
    Node(int key,int freq)
    {
        this.key = key;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int[]{};
        
        HashMap<Integer,Node> hashmap = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>()
                                                     {
                                                         public int compare(Node o1,Node o2)
                                                         {
                                                             return o2.freq - o1.freq;
                                                         }
                                                     });
        
        int n = nums.length;
        for(int i = 0;i < n;i++)
        {
            if(!hashmap.containsKey(nums[i]))
            {
                hashmap.put(nums[i],new Node(nums[i],1));
            }
            else
            {
                int val = hashmap.get(nums[i]).freq;
                val++;
                hashmap.remove(nums[i]);
                hashmap.put(nums[i],new Node(nums[i],val));
            }
        }
        
        Iterator<Integer> itr = hashmap.keySet().iterator();
        while(itr.hasNext())
        {
            int val = itr.next();
            int fre = hashmap.get(val).freq;
            pq.add(hashmap.get(val));
        }
        
        int[] res = new int[k];
        int co = 0;
        while(k-- != 0)
        {
            res[co++] = pq.peek().key;
            pq.poll();
        }
        return res;
    }
}
