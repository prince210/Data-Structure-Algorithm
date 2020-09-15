// Question Link : 


// Question Desc : 


// code : 

public class count_palindromic_substr
{
    public static void main(String[] args) {
        String str = "aaa";

        countPalindromicSubstr(str);
    }

    public static void countPalindromicSubstr(String str)
    {
	// substring of length 1 is always palindrome
	int count = 0;
	int n = str.length();
        boolean[][] dp = new boolean[n][n];
	for(int i = 0;i < str.length();i++)
	{
	    count++;
	    dp[i][i] = true;
	}
	
	// substring of length 2 is palindrome if str.charAt(0) == str.charAt(1)
	for(int i=0;i<n-1;i++)
	{
	    int j = i+1;
	    if(str.charAt(i) == str.charAt(j))
	    {
		count++;
		dp[i][j] = true;
	    }
	}

	// substring of length 3 or more is palindrome if the character between them are palindrome
	// we can check it by checking if terminal character are equal and if dp[i+1][j-1] is true
	
	for(int k = 3;k <= n;k++)
	{
	     for(int i = 0;i <= n-k;i++)
	     {
		 int j = i+k-1;
		 if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1])
		 {
		      dp[i][j] = true;
		      count++;
		 }
	     }   
	}

	System.out.println(count);
    }
}
