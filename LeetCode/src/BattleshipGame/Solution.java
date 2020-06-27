package BattleshipGame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Solution {

    public static String solution(int N, String S, String T) {

        Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));
        String[] ships = S.split(",");
        int sunk=0, hit=0;

        for(String ship : ships){
            System.out.println("ship "+ship);
            Set<String> shipComponent = new HashSet<>();
            char top = ship.charAt(0);
            char left = ship.charAt(1);
            char bottom = ship.charAt(3);
            char right = ship.charAt(4);

            for(char i=top;i<=bottom;i++){
                for(char j=left;j<=right;j++){
                    shipComponent.add(""+i+j);
                }
            }

            if(hits.containsAll(shipComponent))
                sunk+=1;
            else{
                for(String shipPart: shipComponent){
                    if(hits.contains(shipPart))
                        hit+=1;
                }
            }

        }
        return ""+sunk+","+hit;

    }

    public static void main(String[] args) {
        //  String ans = solution(4,"1B 2C,2D 4D","2B 2D 3D 4D 4A");
        //String ans = solution(12, "1A 2A,12A 12A", "12A");
        String ans = solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
        System.out.println(ans);
    }
}
