import java.util.Comparator;
import java.util.PriorityQueue;

// Most Important ---------------------------> For coding interview
class huffManNode
{
    int data;
    char messageChar;
    huffManNode left;
    huffManNode right;
    huffManNode()
    {
        left = right = null;
    }
}


// Most Important ---------------------------> For coding interview
public class huffman_coding_most_imp
{
    static int totalBitCount = 0;
    public static void main(String[] args) {
        char[] arr = {'A','B','C','D','E'};
        int[] freqCount = {3,5,6,4,2};

//        char []arr = {'A', 'B', 'C', 'D', 'E', 'F'};
//        int[] freqCount = { 5, 9, 12, 13, 16, 45 };


        // Time - O(nlogn)      space - O(n)
        huffManCoding(arr,freqCount);
    }

    public static void huffManCoding(char[] arr,int[] freqCount)
    {
        totalBitCount += arr.length*8; //count bits for each characters

        getCodeForEachChar(freqCount,arr);

        System.out.println(totalBitCount);
    }

    public static void getCodeForEachChar(int[] freqCount,char []arr)
    {
        // number of character
        int charLength = freqCount.length;

        // generate huffman tree then generate code for each level
        PriorityQueue<huffManNode> pq = new PriorityQueue<>(charLength, new Comparator<huffManNode>() {
            @Override
            public int compare(huffManNode o1, huffManNode o2) {
                return o1.data-o2.data;
            }
        });
        for (int i = 0;i < freqCount.length;i++)
        {
            huffManNode hf = new huffManNode();
            hf.data = freqCount[i];
            hf.messageChar = arr[i];
            pq.add(hf);
        }

        huffManNode root = null;
        int n = freqCount.length;
        for (int i = 0;i < n-1; i++)
        {
            huffManNode node1 = pq.peek();
            pq.poll();

            huffManNode node2 = pq.peek();
            pq.poll();

            huffManNode parent = new huffManNode();
            parent.data = node1.data + node2.data;
            parent.messageChar = '-';       // It is just a replacement character just use as flag

            parent.left = node1;
            parent.right = node2;

            root = parent;
            pq.add(parent);
        }
        if (root == null)
        {
            System.out.println("root is null");
            return;
        }
        addCodesAndCountBits(root,"",freqCount,arr,0);
    }

    public static void addCodesAndCountBits(huffManNode root,String code,int[] freqCount,char[] arr,int bitCount)
    {
        if (root.messageChar >= 'A' && root.messageChar <= 'Z')
        {
            System.out.println(root.messageChar+" -> "+code);

            // search for messageChar in arr
            int index = -1;
            for (int i = 0;i < arr.length;i++)
            {
                if (arr[i] == root.messageChar)
                {
                    index = i;
                }
            }
            totalBitCount += freqCount[index]*code.length()+code.length();
            return;
        }

        if(root.left!=null)
        {
            addCodesAndCountBits(root.left,code+"0",freqCount,arr,bitCount);
        }
        if (root.right!=null)
        {
            addCodesAndCountBits(root.right,code+"1",freqCount,arr,bitCount);
        }
    }
}
