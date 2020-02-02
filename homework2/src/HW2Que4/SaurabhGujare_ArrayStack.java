/*
* 4. Consider data: {31, “Name1”}, {24, “Name2”}, {10, “Name3”}, {44, “Name4”}, {81, “Name5”}
* a) Provide Array implementation of Stack all operations for this input data.
* b) Compile and run the code.
* c) What is Stack Array implementation time and space complexity?
* Saurabh Gujare
* NUID. 001424874
* */
package HW2Que4;

public class SaurabhGujare_ArrayStack {

    private int N =5; //Size of an arrayStack
    private int top;
    private SaurabhGujare_Data[] arrayStack = new SaurabhGujare_Data[N];

    public SaurabhGujare_ArrayStack(){
        top = -1;
    }

    public boolean isEmpty(){
        return  top<0;
    }

    public boolean  push(SaurabhGujare_Data data){
        if(top>=N-1){
            System.out.println("Stack Overflow");
            return false;
        }else{
            System.out.println(data);
            arrayStack[++top]= data;
            return true;
        }
    }

    public SaurabhGujare_Data pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }else{
            SaurabhGujare_Data temp =  arrayStack[top];
            arrayStack[top] = null;
            top -= 1;
            return temp;
        }
    }

    public SaurabhGujare_Data peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }else{
            return arrayStack[top];
        }
    }

    public void displayStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }else{
            for(int i=arrayStack.length-1; i>=0;i--){
                System.out.println(" "+arrayStack[i]);
                System.out.println("|---------------------------------------|");
            }
        }
    }

    public static void main(String[] args){

        SaurabhGujare_ArrayStack stack = new SaurabhGujare_ArrayStack();

        System.out.println("\n\nPush Operation");
        stack.push(new SaurabhGujare_Data(31,"Name1"));
        stack.push(new SaurabhGujare_Data(24,"Name2"));
        stack.push(new SaurabhGujare_Data(10,"Name3"));
        stack.push(new SaurabhGujare_Data(44,"Name4"));
        stack.push(new SaurabhGujare_Data(81,"Name5"));
        stack.push(new SaurabhGujare_Data(6,"Name6"));

        System.out.println("\n\nPop Operation");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\n\nPeek Operation");
        System.out.println(stack.peek());

        System.out.println("\n\nDisplay Entire stack\n");
        stack.displayStack();


    }
}
