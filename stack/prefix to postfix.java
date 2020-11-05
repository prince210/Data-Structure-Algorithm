import java.util.Stack;

public class perfix_to_postfix
{
    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        convertPrefixToPostfix(exp);
    }
    public static void convertPrefixToPostfix(String exp)
    {
        // reverse the string
        String str = "";
        Stack<String> stack = new Stack<>();
        for (int i=exp.length()-1;i>=0;i--)
        {
            str += exp.charAt(i);
        }
        // if operand push it into the stack
        // if operator pop and again pop then put into their combined version in stack
        for (int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='A' && str.charAt(i)<='Z')
            {
                stack.push(str.substring(i,i+1));
            }
            else {
                String temp = stack.pop() + stack.pop() + str.charAt(i);
                stack.push(temp);
            }
        }
        System.out.println(stack.pop());
    }
}
