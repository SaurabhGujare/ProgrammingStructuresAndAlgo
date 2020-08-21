package RobinhoodCodingRound;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
/*
* Consider a function rev which reverses the digits in an integer.
* Here are some examples: rev(103) = 301 . rev(2400) = 42 rev(9) = 9 .
* Given an array of non-negative integers arr , your task is to count the number of pairs (i, j)
* such that is j and arr[i] + rev(arr[j]) = arr[j] + rev(arr[i]). Example • For arr = [1, 20, 2, 11] ,
* the output should be oppositeSums (arr) = 7. o For (i, j) = (0,0) equality holds: 1 + 1 = 1 + 1,
* • For (i, j) = (0, 1) equality doesn't hold: 1 + 2 # 20 + 1,
* • For (i, j) = (0, 2) equality holds: 1 + 2 = 2 + 1,
* • For (i, j) = (0, 3) equality holds: 1 + 11 = 11 + 1,
* • For (i, j) = (1, 1) equality holds: 20 + 2 = 20 + 2,
* • For (i, j) = (1, 2) equality doesn't hold: 20 + 2 + 2 + 2,
* • For (i, j) = (1, 3) equality doesn't hold: 20 + 11 # 11 + 2 ,
* • For (i, j) = (2, 2) equality holds: 2 + 2 = 2 + 2,
* */

public class OppositeSums {

    private int reverseInteger(int num){
        int output = 0;
        while(num!=0){
            System.out.println(output+" num:- "+num%10);
            output = (output * 10)+(num % 10);
            num /= 10;
        }
        return output;
    }

    private int oppositeSum(int[] arr){
        return 0;
    }

    public static void main(String[] args){
        OppositeSums obj = new OppositeSums();
        System.out.println(obj.reverseInteger(379));
    }
}
