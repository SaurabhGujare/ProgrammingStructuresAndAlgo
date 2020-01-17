/*
* Consider String “It was the best of time”.  Start with the first word, design a Stack such that
* when you read back the words, the order of string does not change.
* Provide code for all necessary operations of Stack. Compile and run the code.
* Saurabh Gujare
* NUID. 001424874
* */

package HW1Que7;

import java.util.Stack;

public class HW1Que7 {

    public static void main(String[] args){
        Stack<String> inputStack = new Stack<>();
        Stack<String> outputStack = new Stack<>();
        enter_Input(inputStack);
        change_Input_Order(inputStack,outputStack);
        display_Output(outputStack);

    }

    public static void enter_Input(Stack<String> inputStack){
        inputStack.push("It");
        inputStack.push("was");
        inputStack.push("the");
        inputStack.push("best");
        inputStack.push("of");
        inputStack.push("time");

        System.out.println("Input Stack Content:- "+ inputStack);
    }

    public static void change_Input_Order(Stack<String> inputStack,  Stack<String> outputStack){
        while(!inputStack.empty()) {
            outputStack.push(inputStack.pop());
        }
    }

    public static void display_Output(Stack<String> outputStack){
        System.out.println("\n\nReading back the words with order unchanged:->\n");
        while(!outputStack.empty()){
            System.out.print(outputStack.pop()+" ");
        }
        System.out.println("\n_______________________");
    }
}