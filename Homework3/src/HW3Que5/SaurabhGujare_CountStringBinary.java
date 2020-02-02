package HW3Que5;

public class SaurabhGujare_CountStringBinary {

    public static int countStringBinary(int N){
        if(N<=0)
            return 1;
        else
            return countStringBinary(N-2)+countStringBinary(N-1);

    }

    public static void main(String[] args){


        System.out.println("For n=1 count of binary strings without two consecutive 1s is "+countStringBinary(1));
        System.out.println("For n=2 count of binary strings without two consecutive 1s is "+countStringBinary(2));
        System.out.println("For n=3 count of binary strings without two consecutive 1s is "+countStringBinary(3));
        System.out.println("For n=4 count of binary strings without two consecutive 1s is "+countStringBinary(4));
        System.out.println("For n=5 count of binary strings without two consecutive 1s is "+countStringBinary(6));

    }
}
