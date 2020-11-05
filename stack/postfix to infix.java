import java.util.Stack;

public class postfix_to_infix
{
    public static void main(String[] args) {
        String exp = "ab*c+";
        convertToInfix(exp);
    }

    public static void convertToInfix(String exp)
    {
        Stack<String> stack = new Stack<>();
        for (int i=0;i<exp.length();i++)
        {
            if (exp.charAt(i) >= 'a' && exp.charAt(i)<='z')
            {
                stack.push(exp.substring(i,i+1));
            }
            else
            {
                String str1 = stack.pop();
                String str2 = stack.pop();

                String temp = "(" +str2+exp.charAt(i)+str1+ ")";
                stack.push(temp);
            }
        }

        System.out.println(stack.pop());
    }
}
