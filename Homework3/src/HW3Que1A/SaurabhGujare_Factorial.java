package HW3Que1A;

public class SaurabhGujare_Factorial {

    public static int fact(int N){
        return N<=1?1:N*fact(N-1);
    }

    public static void main(String[] args){
        System.out.println("The factorial of 7 is "+fact(7));

    }
}
