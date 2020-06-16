package HW11Que01.HW11Que2a;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_StringSearchBruteForce {

    public static int search(String text, String pattern){

        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        for( int i = 0; i <= lengthOfText - lengthOfPattern ; i++){

            int j;

            for( j=0;j<lengthOfPattern;j++){
                if( text.charAt(i+j) != pattern.charAt(j)){
                    break;
                }
            }

            if( j == lengthOfPattern ) return i;
        }

        return lengthOfText;
    }

    public static void main(String[] args){
        String text="ABCADCBABABCDABCDABDE";
        String pattern="BCD";
        int output = search(text,pattern);
        System.out.println("The substring "+pattern+" inside "+text+" is at "+output);
    }
}
