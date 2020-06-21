package HW11Que5;

import java.util.Arrays;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_GreedyAlgo {
    public static void greedyAlgo(int[] times,int T){
        int greedyTime = times[0];
        Arrays.sort(times);
        for(int i=1;i<times.length;i++){
            if(greedyTime>=T){
                System.out.println("Total number of tasks performed in time '"+T+"' are: "+i);
                break;
            }
            greedyTime = greedyTime+times[i];
        }
    }

    public static void main(String[] args){
        SaurabhGujare_GreedyAlgo Time = new SaurabhGujare_GreedyAlgo();
        int times[] = new int[] {8,7,6,5,4,3,2,1};
        int T = 15;
        greedyAlgo(times,T);
    }
}
