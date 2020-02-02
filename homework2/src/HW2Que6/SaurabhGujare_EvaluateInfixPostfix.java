/*
* Human use Infix expression and computers use Postfix expression.
* You are to write a simple Calculator. There are three steps:
* a) Read Infix expression, b) Convert Infix expression to Postfix by hand, and
* c) Evaluate Postfix expression,
* d) Use part (c) and write Java code, compile and run with three Infix expression examples.
*   (1 + 2 * (20 / 5 ))
*   (1 + 3 + ( ( 4 / 2 ) * ( 8 * 4 ) ))
*   (4 + 8) * (6 - 5)/((3 - 2) * (2 + 2))
* Saurabh Gujare
* NUID: 001424874
*/
package HW2Que6;

import java.util.Stack;

public class SaurabhGujare_EvaluateInfixPostfix {

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

    static int performOperation(Stack<Integer> operands, Stack<Character> operators){
        int a = operands.pop();
        int b = operands.pop();
        char operation = operators.pop();

        switch(operation){
            case '+':
                return a+b;
            case '-':
                return b-a;
            case '*':
                return a*b;
            case '/':
                if(a==0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b/a;
        }
        return 0;
    }

    public boolean isOperator(char c){
        return(c=='+'|| c=='-'|| c=='/'|| c=='*'|| c=='^');
    }

    static String infixToPostFix(String expression){

        // initializing empty String for result
        String result = new String("");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<expression.length(); ++i)
        {
            char c = expression.charAt(i);

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

    public int evaluateInfixExpression(String expression){
        //Stack  for numbers
        Stack<Integer> operands = new Stack<>();

        //Stack for operations
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<expression.length();i++){
            char c = expression.charAt(i);
            //Check if char is digit
            if(Character.isDigit(c)){
                //What is char is not one digit
                int num = 0;
                while(Character.isDigit(c)){
                    num = num*10+(c-'0');
                    i++;
                    if(i<expression.length())
                        c= expression.charAt(i);
                    else
                        break;
                }
                i--;
                operands.push(num);
            }else if(c =='('){
                operators.push('(');
            }else  if(c==')'){
                //perform operation
                while(operators.peek()!='('){
                    int  result = performOperation(operands,operators);
                    operands.push(result);
                }
                //remove ( from operators stack
                operators.pop();
            }else if(isOperator(c)){
                //Check c's precedence with the top of operators stack
                //if precendence(c)<precedence(top) then perform process until c's precedence is less or stack is empty
                //else push operator to the stack
                while(!operators.isEmpty() && precedence(c)<precedence(operators.peek())){
                    int result = performOperation(operands,operators);
                    operands.push(result);

                }
                //push current operator
                operators.push(c);

            }
        }

        //Entire operators are being used to perform operations
        //Perform remaining operations
        while(!operators.isEmpty()){
            int result = performOperation(operands, operators);
            operands.push(result);
        }

        return operands.pop();
    }

    public int evaluatePostfixExpression(String expression){
        //Stack  for numbers
        Stack<Integer> operands = new Stack<>();

        //Stack for operations
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);

            if(c == ' ')
                continue;

            if(isOperator(c)){
                operators.push(c);
                int result = performOperation(operands,operators);
                operands.push(result);
            }else{
                //What is char is not one digit
                int num = 0;
                while(Character.isDigit(c)){
                    num = num*10+(c-'0');
                    i++;
                    if(i<expression.length())
                        c= expression.charAt(i);
                    else
                        break;
                }
                i--;
                operands.push(num);
            }
        }

        return operands.pop();

    }

    public static void main(String[] args){
        String[] infixExpressionsSet = {"(1+2*(20/5))","(1+3+((4/2)*(8*4)))","(4+8)*(6-5)/((3-2)*(2+2))"};
        String[] postfixExpressionSet = {"1 2 20 5 / * +","1 3 + 4 2 / 8 4 * * +","4 8 + 6 5 - * 3 2 - 2 2 + * /"};
        SaurabhGujare_EvaluateInfixPostfix obj = new SaurabhGujare_EvaluateInfixPostfix();

        for(int i = 0;i<infixExpressionsSet.length;i++){
            System.out.println("\nInfix Expression: "+infixExpressionsSet[i]);
            System.out.println("Postfix Expression: "+infixToPostFix(infixExpressionsSet[i]));
            System.out.println("Evaluate Infix Expression: "+obj.evaluateInfixExpression(infixExpressionsSet[i]));
        }
        System.out.println("\n");
        for(int i = 0;i<postfixExpressionSet.length;i++){
            System.out.println("\nPostfix Expression: "+postfixExpressionSet[i]);
            System.out.println("Evaluate Postfix Expression: "+obj.evaluatePostfixExpression(postfixExpressionSet[i]));
        }
    }
}
