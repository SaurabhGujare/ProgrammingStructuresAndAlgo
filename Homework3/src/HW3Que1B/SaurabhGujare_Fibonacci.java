package HW3Que1B;

public class SaurabhGujare_Fibonacci {
    public static int fibonacciRecursive(int N){
        if(N==0)
            return 0;
        else if (N==1||N==2)
            return 1;
        else
            return fibonacciRecursive(N-2)+fibonacciRecursive(N-1);

    }

    public static int fibonacciIteraive(int N){
        int a = 0, b=1,sum=0;
        if(N==0)
            return 0;
        else if (N==1||N==2)
            return 1;

        for(int i=1;i<N;i++){
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println("The fibonacci Series using recursive method is \n");
        for(int i=0;i<6;i++){
            System.out.print(fibonacciRecursive(i)+" ");
        }

        System.out.println("\nThe fibonacci Series using iterative method is \n");
        for(int i=0;i<6;i++){
            System.out.print(fibonacciIteraive(i)+" ");
        }
    }
}
