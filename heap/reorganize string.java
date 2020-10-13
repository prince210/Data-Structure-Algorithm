// question link : https://leetcode.com/problems/reorganize-string/

class Node
{
    char ch;
    int freq;
    
    Node(char ch,int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public static void main(String[] args)
    {
        String s = "aaabbc";
        String res = reorganizeString(s);
        System.out.println(res);
    }
    public static String reorganizeString(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        HashMap<Character,Node> hashmap = new HashMap<>();
        
        for(int i = 0;i < s.length();i++)
        {
            if(!hashmap.containsKey(s.charAt(i)))
            {
                hashmap.put(s.charAt(i),new Node(s.charAt(i),1));
            }
            else
            {
                Node temp = hashmap.get(s.charAt(i));
                int val = temp.freq;
                val++;
                temp.freq = val;
                hashmap.remove(s.charAt(i));
                hashmap.put(s.charAt(i),temp);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node n1,Node n2)
            {
                return n2.freq - n1.freq;
            }
        });
        Iterator<Character> iter = hashmap.keySet().iterator();
        while(iter.hasNext())
        {
            char ch = iter.next();
            pq.add(hashmap.get(ch));
        }
        
        StringBuilder sb = new StringBuilder("");
        while(pq.size()>1)
        {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            
            sb.append(n1.ch);
            sb.append(n2.ch);
            
            n1.freq--;
            n2.freq--;
            
            if(n1.freq > 0)
            {
                pq.add(n1);
            }
            
            if(n2.freq > 0)
            {
                pq.add(n2);
            }
        }
        
        if(!pq.isEmpty())
        {
            if(pq.peek().freq == 1)
            {
                sb.append(pq.poll().ch);
            }
            else
            {
                return "";
            }
        }
        
        return sb.toString();
    }
}
