// Question Link : https://www.geeksforgeeks.org/painting-fence-algorithm/

public class paint_fence_imp
{
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        int same = k; // when we had painted last two fence with same color
        int diff = k*(k-1); // when we has painted last two fence with diff color

        int total = same + diff;
        for (int i = 3;i <= n;i++)
        {
            same = diff;
            diff = total*(k-1);
            total = same + diff;
        }
        System.out.println(total);
    }
}
