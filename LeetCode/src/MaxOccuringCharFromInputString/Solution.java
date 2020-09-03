package MaxOccuringCharFromInputString;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Solution {
    static final int ASCII_Size = 256;

    static char getMaxOccuringChar(String str){
        int[] count = new int[ASCII_Size];

        for(int i=0; i<str.length(); i++)
            count[str.charAt(i)]++;

        //find the max char

        int max = -1;
        char result =' ';

        for(int i=0; i<str.length(); i++)
            if(max<count[str.charAt(i)]){
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        System.out.println(max);
        return result;
    }

    // Driver Method
    public static void main(String[] args)
    {
//        String str = "sample string";
        String str = "test";
        System.out.println("Max occurring character is " +
                getMaxOccuringChar(str));
    }
}
