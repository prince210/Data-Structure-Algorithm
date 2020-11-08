import java.util.Stack;

public class prefix_to_infix
{
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        covertToInfix(exp);
    }

    public static void covertToInfix(String exp)
    {
        Stack<String> stack = new Stack<>();
        String str = "";
        for (int i=exp.length()-1;i>=0;i--)
        {
            str += exp.charAt(i);
        }

        for (int i=0;i<exp.length();i++)
        {
//            System.out.println(stack.peek());
            if (str.charAt(i)>='A' && str.charAt(i)<='Z')
            {
                String temp = str.substring(i,i+1);
                stack.push(temp);
            }
            else
            {
                String temp = "("+stack.pop()+str.charAt(i)+stack.pop()+")";
                stack.push(temp);
            }
        }
        System.out.println(stack.pop());
    }
}
