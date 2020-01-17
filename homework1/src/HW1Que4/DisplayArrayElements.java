/*
 * Display Array Element
 * Order of Growth: Linear
 * Time Complexity: O(N) = N
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que4;

public class DisplayArrayElements {
    public static void main(String[] args) {
        int array[] = new int[]{1,2,3,4,5};
        System.out.println("Array elements are: ");
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
}
