package NumberComplement;
import java.lang.Math;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Solution {

    private static int findComplement(int num) {
        int count =0, onesComplement=0;
        num = findBinaryRecursive(num);
        while(num!=0){
            onesComplement+= num%10==0?1*(int)Math.pow(10,count):0;
            num = num/10;
            count++;
        }
        return findBinaryEquivalent(onesComplement,0);
    }

    private static int findBinaryRecursive(int num){
        if (num == 0)
            return 0;
        else
            return (num % 2 + 10 * findBinaryRecursive(num / 2));
    }

    private static int findBinaryEquivalent(int num, int count){
        if(num==0)
            return 0;
        else
            return (num % 10) * (int)Math.pow(2,count) + findBinaryEquivalent(num/10,count+1);
    }

    public static void main(String[] args){
        System.out.println(findBinaryRecursive(1111));
        System.out.println(findComplement(1111));


    }
}
