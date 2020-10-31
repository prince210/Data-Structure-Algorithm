import java.util.Stack;

public class celebrity_problem_important
{
    public static void main(String[] args) {
        int[][] celebrityMatrix = {{0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        int CelebIndex = findCelebrity(celebrityMatrix);
        System.out.println(CelebIndex);
        int celebIs = findCeleb(celebrityMatrix);
        System.out.println(celebIs);
    }

    // brute force -    Time - O(n^2)   space - O(n)
    public static int findCelebrity(int[][] matrix)
    {
        int n = matrix.length;
        int[] ithPersonKnow = new int[n];
        int[] KnownBy = new int[n];

        for (int i =0;i<n;i++)
        {
            for (int j = 0;j<n;j++)
            {
                if (matrix[i][j] == 1)
                {
                    ithPersonKnow[i]++;
                    KnownBy[j]++;
                }
            }
        }

        for (int i=0;i<n;i++)
        {
            if (ithPersonKnow[i] == 0 && KnownBy[i] == n-1)
                return i;
        }
        return -1;
    }

    // Time - O(n)      space - O(n)
    public static int findCeleb(int[][] matrix)
    {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<n;i++)
        {
            stack.push(i);
        }

        while (stack.size()!=1)
        {
            int x = stack.pop();
            int y = stack.pop();

            if (matrix[x][y] == 1) // matrix[x][y] == 1 means xth person knows yth person
                                  // so x is not celebrity because celebrity knows None
            {
                stack.push(y);
            }

            else if (matrix[x][y] == 0) // matrix[x][y] == 0 means xth person don't knows yth person
                                       // so y is not celebrity because celebrity is known by everyone
            {
                stack.push(x);
            }
        }

        int mayBeCeleb = stack.peek();
        stack.pop();
//        System.out.println(mayBeCeleb);

        int ithPersonCount = 0;
        int knownByCount = 0;
        for (int i = 0;i<n;i++)//checking stack empty is not necessary because in this case stack will always contain one element
        {
            if (matrix[mayBeCeleb][i] == 1)
            {
                ithPersonCount++;
            }
            if (matrix[i][mayBeCeleb] == 1)
            {
                knownByCount++;
            }
        }

        if (ithPersonCount == 0 && knownByCount == n-1)
        {
            return mayBeCeleb;
        }
        else
            return -1;
    }
}
