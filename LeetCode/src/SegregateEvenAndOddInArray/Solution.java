package SegregateEvenAndOddInArray;

import java.util.Arrays;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Solution {

    static void segregateEvenOdd(int arr[])
    {
        int left = 0, right = arr.length - 1;
        while(left < right){

            while(arr[left]%2 == 0 && left < right)
                left++;

            while(arr[right]%2 == 1 && left < right)
                right--;

            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    /* Driver program to test above functions */
    public static void main (String[] args)
    {
//        int arr[] = {12, 34, 45, 9, 8, 90, 3};
        int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45 };

        segregateEvenOdd(arr);

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}
