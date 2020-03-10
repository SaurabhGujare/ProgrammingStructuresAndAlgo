package problem2;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 * 1130. Minimum Cost Tree From Leaf Values
 */
public class Solution {
    public int mctFromLeafValues(int[] arr)
    {
        if(arr.length==2)
            return arr[0]*arr[1];
        LinkedList<Integer> ll=new LinkedList<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            ll.add(arr[i]);
        }
        int sum=0;
        while(ll.size()>1)
        {
            int temp1=Integer.MAX_VALUE;
            int min= Collections.min(ll);
            int index=ll.indexOf(min);

            int ind=-1;
            if((index-1)>=0)
            {
                temp1=ll.get(index-1);
                ind=index-1;
            }
            if((index+1)<ll.size() && ll.get(index+1)<temp1)
            {
                temp1=ll.get(index+1);
                ind=index+1;
            }
            else
                ind=index;
            ll.remove(Integer.valueOf(min));
            sum+=min*temp1;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] input = {6,2,4};
        Solution ob = new Solution();
        System.out.println("Output:-"+ob.mctFromLeafValues(input));
    }
}
