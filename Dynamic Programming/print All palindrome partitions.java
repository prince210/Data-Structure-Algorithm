// Question Link : https://leetcode.com/problems/palindrome-partitioning/solution/


import java.util.ArrayList;

public class print_all_palindrome_partition_amazon_OA
{
    public static void main(String[] args) {
        String s = "abaaba";

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        printPalindrome(s,res,new ArrayList<String>());
        System.out.println(res);
    }

    public static void printPalindrome(String s,ArrayList<ArrayList<String>> res,ArrayList<String> temp)
    {
        if (s.equals("") || s.length() == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0;i < s.length();i++)
        {
            String str = s.substring(0,i+1);
            String rem = s.substring(i+1);

            if (isPalind(str))
            {
                temp.add(str);
                printPalindrome(rem,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static boolean isPalind(String str)
    {
        int low = 0;
        int high = str.length()-1;

        while (low <= high)
        {
            if (str.charAt(low) != str.charAt(high))
                return false;

            low++;
            high--;
        }
        return true;
    }
}
