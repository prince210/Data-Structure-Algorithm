import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class first_non_repeating_character_in_stream
{
    public static void main(String[] args) {
        String str = "a a b c";
        firstNonRep(str);
    }

    public static void firstNonRep(String str)
    {
        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if (ch!=' ')
            {
                if (!hashSet.contains(ch))
                {
                    hashSet.add(ch);
                    queue.add(ch);
                    System.out.print(queue.peek()+" ");
                }
                else if (!queue.isEmpty() && hashSet.contains(ch) && queue.peek() == ch)
                {
                    queue.poll();
                    if (queue.isEmpty())
                    {
                        System.out.print(-1+" ");
                    }
                    else
                    {
                        System.out.print(queue.peek()+" ");
                    }
                }
                else
                {
                    if (queue.isEmpty())
                    {
                        System.out.print(-1+" ");
                    }
                    else
                    {
                        System.out.print(queue.peek()+" ");
                        queue.remove(ch);
                    }
                }
            }
        }
        System.out.println();
    }
}
