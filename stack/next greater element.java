package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class next_greater_element
{
    public static void main(String[] args) {
//        int[] arr = {4, 5, 2, 25};
        int[] arr = {40,19,42,26,31,0,5};
        nextGreaterEle(arr);
        nearestGreaterEle(arr); //same as next greater element but with different name
    }

    // Time - O(n^2)        space - O(n) for result array (here we have printed but final answer requires array)
    public static void nextGreaterEle(int[] arr)
    {
        System.out.println("ELE" + "\t-------> " + "NGE");
        for (int i=0;i<arr.length;i++)
        {
            int j = i+1;
            while (j<arr.length && arr[j]<arr[i])
            {
                j++;
            }
            if (j == arr.length)
                System.out.println(arr[i] + "\t-------> " + -1);
            else
                System.out.println(arr[i] + "\t-------> " + arr[j]);
        }
    }

    // Time - O(n)          space - O(n)
    public static void nearestGreaterEle(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=n-1;i>=0;i--)
        {
            if (stack.size() == 0)
            {
                stack.push(arr[i]);
                res.add(-1);
            }
            else
            {
                while (stack.size()>0 && stack.peek()<arr[i])
                {
                    stack.pop();
                }
                if (stack.size() == 0)
                    res.add(-1);
                else {
                    res.add(stack.peek());
                }
                stack.push(arr[i]);
            }
        }
        Collections.reverse(res);
        System.out.println(res);
    }
}


