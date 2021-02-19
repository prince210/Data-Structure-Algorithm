// question Link :https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
// Functional Problem

public class Solution {
    public int coverPoints(int[] x, int[] y) 
    {
        int curX = x[0];
        int curY = y[0];
        int count = 0;
    
        for (int i = 1; i < x.length; i++) {
            int dstX = x[i];
            int dstY = y[i];
            while (curX != dstX || curY != dstY) {
                if (curX < dstX) curX++;
                else if (curX > dstX) curX--;
                if (curY < dstY) curY++;
                else if (curY > dstY) curY--;
                count++;
        }
    }
    return count;
    }
}
