/*
 * Bubble  Sort
 * Order of Growth: quadratic
 * Time Complexity: O(N) = N^2
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que4;

public class BubbleSort {

    public static void main(String args[])
    {
        int arr[] = {2, 1, 3, 15, 6, 4};

        System.out.println("Given Array");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");

        bubbleSort(arr);

        System.out.println("\n\nSorted array");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    static void bubbleSort(int arr[])
    {
        int len = arr.length;
        for (int i = 0; i < len-1; i++)
            for (int j = 0; j < len-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
