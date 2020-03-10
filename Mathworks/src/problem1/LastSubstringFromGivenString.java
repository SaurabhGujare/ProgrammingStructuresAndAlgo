package problem1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LastSubstringFromGivenString {

    public static String returnLastSubstring(String input){
        Set<String> substrings = new TreeSet<String>();
        int n = input.length();
        substrings.add(input);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++)
                substrings.add(input.substring(1,j));
        }

        Iterator iterator = substrings.iterator();
        String output = "";
        while(iterator.hasNext()){
            output  = (String)iterator.next();
        }
        return output;
    }

    public static void main(String[] args){

        String input = "ba";

        System.out.println("Output:-"+returnLastSubstring(input));


    }
}
