// question link : https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

class SLLNode
{
    int data;
    SLLNode next;
    SLLNode(int data)
    {
        this.data = data;
    }
}

public class merge_k_sorted_linkedList
{
    public static void main(String[] args) {
        int k = 3;
        int n = 4; // number of element in each linked List

        SLLNode[] headNodesArr = new SLLNode[k];
        headNodesArr[0] = new SLLNode(1);
        headNodesArr[0].next = new SLLNode(3);
        headNodesArr[0].next.next = new SLLNode(5);
        headNodesArr[0].next.next.next = new SLLNode(7);

        headNodesArr[1] = new SLLNode(2);
        headNodesArr[1].next = new SLLNode(4);
        headNodesArr[1].next.next = new SLLNode(6);
        headNodesArr[1].next.next.next = new SLLNode(8);

        headNodesArr[2] = new SLLNode(0);
        headNodesArr[2].next = new SLLNode(9);
        headNodesArr[2].next.next = new SLLNode(10);
        headNodesArr[2].next.next.next = new SLLNode(11);

        mergeKLinkedList(headNodesArr,k);

        mergeUsingHeap(headNodesArr,k);
    }


    public static void mergeUsingHeap(SLLNode []arr,int k)
    {
        PriorityQueue<SLLNode> pq = new PriorityQueue<>(new Comparator<SLLNode>() {
            @Override
            public int compare(SLLNode o1, SLLNode o2) {
                return o1.data-o2.data;
            }
        });

        // first insert first element of all arr
        for (int i = 0;i < k;i++)
        {
            pq.add(arr[i]);
        }

        SLLNode head = null;
        SLLNode curr = head;
        while (!pq.isEmpty())
        {
            SLLNode temp = pq.poll();

            if (temp.next!=null)
            {
                pq.add(temp.next);
            }
            if (head == null)
            {
                head = temp;
                curr = temp;
            }
            else
            {
                curr.next = temp;
                curr = temp;
            }
        }
        SLLNode temp = head;
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Time - O(n*k*logk)       space - O(n*k)
    public static void mergeKLinkedList(SLLNode []arr,int k)
    {
        SLLNode headNode1 = arr[0];
        for (int i = 1;i < k;i++)
        {
            headNode1 = merge(headNode1,arr[i]);
        }

        SLLNode curr = headNode1;
        while (curr != null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static SLLNode merge(SLLNode head1,SLLNode head2)
    {
        SLLNode temp1 = head1;
        SLLNode temp2 = head2;
        SLLNode head = null;
        SLLNode curr = head;

        while (temp1!=null && temp2!=null)
        {
            if (temp1.data <= temp2.data)
            {
                if (head == null)
                {
                    head = new SLLNode(temp1.data);
                    temp1 = temp1.next;
                    curr = head;
                }
                else
                {
                    curr.next = new SLLNode(temp1.data);
                    curr = curr.next;
                    temp1 = temp1.next;
                }
            }
            else
            {
                if (head == null)
                {
                    head = new SLLNode(temp2.data);
                    temp2 = temp2.next;
                    curr = head;
                }
                else
                {
                    curr.next = new SLLNode(temp2.data);
                    curr = curr.next;
                    temp2 = temp2.next;
                }
            }
        }

        while (temp1!=null)
        {
            curr.next = new SLLNode(temp1.data);
            curr = curr.next;
            temp1 = temp1.next;
        }

        while (temp2!=null)
        {
            curr.next = new SLLNode(temp2.data);
            curr = curr.next;
            temp2 = temp2.next;
        }
        return head;
    }
}
