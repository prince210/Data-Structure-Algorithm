import java.util.Stack;

public class maximum_diff_between_nearest_left_right_smaller
{
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 5, 1, 7};

//        int[] arr = {88,57,44,92,28,66,60,37,33,52,38,29,76,8,75};
        findMaxDiff(arr);
    }

    public static void findMaxDiff(int[] arr)
    {
        int n = arr.length;
        int []left = new int[n];
        int[] right = new int[n];

        getNearestSmallerLeft(arr,left);
        getNearestSmallerRight(arr,right);

        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++)
        {
            max = Math.max(max,Math.abs(left[i] - right[i]));
        }
        System.out.println(max);
    }
    public static void getNearestSmallerLeft(int[] arr,int[] left)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<arr.length;i++)
        {
            if (stack.size() == 0)
            {
                stack.push(0);
                left[i] = 0;
            }
            else
            {
                while (!stack.isEmpty() && stack.peek()>=arr[i])
                {
                    stack.pop();
                }
                if (stack.size() == 0)
                {
                    left[i] = 0;
                }
                else
                {
                    left[i] = (stack.peek());
                }
                stack.push(arr[i]);
            }
        }

        for (int i=0;i<arr.length;i++)
        {
            System.out.print(left[i]+" ");
        }
        System.out.println();
    }
    public static void getNearestSmallerRight(int[] arr,int[] right)
    {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i=n-1;i>=0;i--)
        {
            if (stack.size() == 0)
            {
                stack.push(arr[i]);
                right[i] = 0;
            }
            else {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    right[i] = 0;
                } else {
                    right[i] = (stack.peek());
                }
                stack.push(arr[i]);
            }
        }
        for (int i=0;i<arr.length;i++)
            System.out.print(right[i]+" ");
        System.out.println();
    }

}
