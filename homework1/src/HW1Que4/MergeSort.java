/*
 * Merge  Sort
 * Order of Growth: linearithmic
 * Time Complexity: O(N) = N.LogN
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que4;

public class MergeSort {

    public static void main(String[] args){
        int arr[] = {2, 1, 3, 15, 6, 4};

        System.out.println("Given Array");
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");

        sort(arr, 0, arr.length-1);

        System.out.println("\n\nSorted array");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    static void sort(int arr[], int low, int high){
        if(low < high){
            int mid = (low+high)/2;

            sort(arr,low,mid);
            sort(arr,mid+1,high);

            merge(arr, low,mid,high);
        }
    }

    static void merge(int arr[], int low, int mid, int high){

        //Find thee size of an array to be merge
        int len1 = mid-low+1;
        int len2 = high - mid;

        //Create temp arrays
        int left[] = new int[len1];
        int right[] = new int[len2];

        //Copy data into the temp arrays
        for(int i=0;i<len1;++i) left[i]  = arr[low+i];

        for(int j=0;j<len2;++j) right[j] = arr[mid+1+j];

        /*Merge two arrays*/

        int i=0, j=0, k=low;

        while(i<len1 &&  j<len2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;

        }

        /* Copy remaining elements of left[] if any */
        while (i < len1)
        {
            arr[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of right[] if any */
        while (j < len2)
        {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
