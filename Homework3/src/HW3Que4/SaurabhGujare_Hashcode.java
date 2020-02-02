package HW3Que4;

import java.math.BigDecimal;

public class SaurabhGujare_Hashcode {
    static double hash = 0;

    public static double hash_Code(String s)
    {
        for(int i=0; i<s.length(); i++)
        {
            hash=hash+((Math.pow(31,s.length()-1-i))*s.charAt(i));
        }
        return hash;
    }

    public static void main(String args[]) {
        String myString = "Welcome Students to Class";

        hash_Code(myString);

        BigDecimal bd = BigDecimal.valueOf(hash);
        bd.toString();

        System.out.println("The hash value is "+hash);
    }
}
