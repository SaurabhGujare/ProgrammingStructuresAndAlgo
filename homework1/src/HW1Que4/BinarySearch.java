/*
 * Binary Search
 * Order of Growth: logarithmic
 * Time Complexity: O(N) = logN
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que4;

public class BinarySearch {

    public static void main(String[] args){
        int[] input = {1,3,5,7,9,11,13,15};
        int key = 7;
        int output = binarySearch(input, key);
        if(output==-1){
            System.out.println(key+" is not present");
        }else{
            System.out.println(key+" is present at index "+output);
        }

    }

    public static int binarySearch(int[] input, int key){
        int len = input.length;
        int low = 0, high = len-1, mid = 0;

        while(high>low){
            mid = (low+high)/2;
            if(key > input[mid]){
                low = mid+1;
            }else if(key<input[mid]){
                high = mid-1;
            }else{
                return mid;
            }
        }
    return -1;

    }
}
