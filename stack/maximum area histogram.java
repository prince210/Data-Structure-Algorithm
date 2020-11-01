import java.util.Stack;

public class maximum_area_histogram_very_imp
{
    public static void main(String[] args) {
        int[] arr = {1,1};
        maxArea(arr);
    }
    public static void maxArea(int[] arr)
    {
        int n = arr.length;
        int[] nearestSmallerLeft = new int[n];
        int[] nearestSmallerRight = new int[n];

        getNearestSmallerLeft(arr,nearestSmallerLeft);
        getNearestSmallerRight(arr,nearestSmallerRight);

        int area = Integer.MIN_VALUE;
        for (int i=0;i<n;i++)
        {
            area = Math.max(area,arr[i] * (nearestSmallerRight[i]-nearestSmallerLeft[i]-1));
        }
        System.out.println(area);
    }

    public static void getNearestSmallerLeft(int[] arr,int []nearestSmallerLeft)
    {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++)
        {
            if (stack.size() == 0)
            {
                nearestSmallerLeft[i] = -1;
                stack.push(i);
            }
            else
            {
                while (stack.size()>0 && arr[i]<=arr[stack.peek()])
                {
                    stack.pop();
                }
                if (stack.size() == 0)
                {
                    nearestSmallerLeft[i] = -1;
                }
                else
                {
                    nearestSmallerLeft[i] = stack.peek();
                }
                stack.push(i);
            }
        }

        for (int i=0;i<n;i++)
        {
            System.out.print(nearestSmallerLeft[i]+" ");
        }
        System.out.println();
    }

    public static void getNearestSmallerRight(int[] arr,int[] nearestSmallerRight)
    {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1;i>=0;i--)
        {
            if (stack.size() == 0)
            {
                stack.push(i);
                nearestSmallerRight[i] = n;
            }
            else
            {
                while (stack.size()>0 && arr[stack.peek()]>=arr[i])
                {
                    stack.pop();
                }
                if (stack.size() == 0)
                {
                    nearestSmallerRight[i] = n;
                }
                else
                {
                    nearestSmallerRight[i] = stack.peek();
                }
                stack.push(i);
            }
        }

        for (int i=0;i<n;i++)
        {
            System.out.print(nearestSmallerRight[i]+" ");
        }
        System.out.println();
    }
}
