/*
* 7. Consider the following Algorithm to convert Infix expression to Postfix.
* a) Infix expression example:  4 + 8 * 6 - 5 / 3 - 2 * 2 + 2
* b) Apply Infix expression convert to Postfix Algorithm, show step-by-step
* c) Write Java code for the algorithm to convert Infix to Postfix expression
* Saurabh Gujare
* NUID. 001424874
*/
package HW2Que7;

import java.util.Stack;

public class SaurabhGujare_ConvertInfixToPostfix {

    static int precedence(char c){
        if(c == '+'){
            return 1;
        }else if(c == '-'){
            return 1;
        }else  if(c == '/'){
            return 2;
        }else if(c == '*'){
            return 2;
        }else if(c == '^'){
            return 3;
        }else{
            return -1;
        }

    }

    static String infixToPostFix(String expression){

        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<expression.length(); ++i)
        {
            char c = expression.charAt(i);

            if(c == ' ')
                continue;

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args){
        String infixExpression = "4 + 8 * 6 - 5 / 3 - 2 * 2 + 2";
        System.out.println("Infix Expression: "+infixExpression);
        System.out.println("Postfix Expression: "+infixToPostFix(infixExpression));
    }
}
