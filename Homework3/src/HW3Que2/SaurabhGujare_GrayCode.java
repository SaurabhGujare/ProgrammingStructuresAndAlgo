package HW3Que2;

import java.util.ArrayList;
import java.util.List;

public class SaurabhGujare_GrayCode {

    static List<Integer> grayCode(int N){

        if(N<=0){
            List<Integer> grayCodes = new ArrayList<>();
            grayCodes.add(0);
            return  grayCodes;
        }else{

            int numToAdd = 1<<(N-1);
            List<Integer> grayCodes = grayCode(N-1);

            for(int i=grayCodes.size()-1;i>=0;i--){
                grayCodes.add(numToAdd+grayCodes.get(i));
            }
            return grayCodes;
        }
    }

    public static void main(String[] args){

        System.out.println("For n=3\n"+grayCode(2));

        for(Integer ele: grayCode(2)){
            System.out.print(Integer.toBinaryString(ele)+" ");
        }

    }


}
