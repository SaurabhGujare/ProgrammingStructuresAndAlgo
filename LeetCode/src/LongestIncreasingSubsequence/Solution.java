package LongestIncreasingSubsequence;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Solution {

    private static int lis(int[] nums){

        if(nums.length==0) return 0;
        if(nums.length==1) return 1;

        int len  = nums.length;
        int op =-1;

        for(int i=0;i<len-1;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            for(int j=i+1;j<len;j++){
                int temp = list.get(list.size()-1);
                if(nums[j]>temp){
                    list.add(nums[j]);
                }
            }

            op=op<list.size()?list.size():op;
        }

    return op;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3, 10, 2, 1, 20};
        System.out.println("The longest increasing subsequence is "+lis(nums));
    }
}
