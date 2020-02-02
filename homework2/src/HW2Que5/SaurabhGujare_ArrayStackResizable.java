/*
* 5. Suppose in problem-4 the array size was: a) too large, or b) too small.
* How would you manage resizing the array for (a) and (b).
* Write the code, compile and test the program. Also discuss the running time/space complexity of your approach.
* Saurabh Gujare
* NUID. 001424874
* */
package HW2Que5;

public class SaurabhGujare_ArrayStackResizable {
    private int N;
    private SaurabhGujare_Data[] arrayStack;

    public SaurabhGujare_ArrayStackResizable(int size){
        this.N = 0;
        this.arrayStack = new SaurabhGujare_Data[size];
    }

    private void resize(int capacity){
        SaurabhGujare_Data[] copyArray = new SaurabhGujare_Data[capacity];
        for(int i=0;i<N;i++)
            copyArray[i] = arrayStack[i];
        this.arrayStack = copyArray;

    }

    public boolean isEmpty(){
        return  this.arrayStack.length<=0;
    }

    public boolean  push(SaurabhGujare_Data data){
        if(N==arrayStack.length)
            resize(arrayStack.length*2);
        System.out.println(data);
        arrayStack[N++]= data;
        return true;
    }

    public SaurabhGujare_Data pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }else{
            SaurabhGujare_Data temp =  arrayStack[--N];
            arrayStack[N] = null;
            if(N>0 && N<=arrayStack.length/4){
                resize(arrayStack.length/2);
            }
            return temp;
        }
    }

    public SaurabhGujare_Data peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }else{
            return arrayStack[N];
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

        SaurabhGujare_Data[] smallArray = new SaurabhGujare_Data[1];
        SaurabhGujare_Data[] bigArray = new SaurabhGujare_Data[100];

        SaurabhGujare_ArrayStackResizable smallArrayStack = new SaurabhGujare_ArrayStackResizable(8);
        SaurabhGujare_ArrayStackResizable bigArrayStack = new SaurabhGujare_ArrayStackResizable(100);

        SaurabhGujare_Data d1 =new SaurabhGujare_Data(31, "Name1");
        SaurabhGujare_Data d2 =new SaurabhGujare_Data(24, "Name2");
        SaurabhGujare_Data d3 =new SaurabhGujare_Data(10, "Name3");
        SaurabhGujare_Data d4 =new SaurabhGujare_Data(44, "Name4");
        SaurabhGujare_Data d5 =new SaurabhGujare_Data(81, "Name5");

        smallArrayStack.push(d1);
        smallArrayStack.push(d2);
        smallArrayStack.pop();

        bigArrayStack.push(d2);
        bigArrayStack.push(d3);
        bigArrayStack.push(d4);
        bigArrayStack.push(d5);
        bigArrayStack.pop();

        System.out.println("\n\nWhen array size is too small -> Size = 8");
        smallArrayStack.displayStack();

        System.out.println("\n\nWhen array size is too large -> Size = 100");
        bigArrayStack.displayStack();

    }
}
