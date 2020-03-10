package ValidParentheses;

import java.util.Stack;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        int N = s.length();

        if(N==0||N%2==1)
            return false;

        Stack<Character> openParentheses = new Stack<>();

        for(int i=0;i<N;i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='[') {
                openParentheses.push(s.charAt(i));
                System.out.println(openParentheses.peek());
            }
            else{
                if(openParentheses.isEmpty())
                    return false;

                if((s.charAt(i)=='}' && openParentheses.peek()!='{') || (s.charAt(i)==')' && openParentheses.peek()!='(') || (s.charAt(i)==']' && openParentheses.peek()!='[')){
                    System.out.println("yryutr"+openParentheses.peek());
                    return false;
                }
                openParentheses.pop();
            }

        }

        return openParentheses.isEmpty();
    }

    public static void main(String[] args){
        String[] array = {"()","()[]{}","(]","([)]","{[]}"};

//        for(String ele: array){
//            System.out.println(isValid(ele));
//        }
        System.out.println(isValid("()[]{}"));

    }
}
