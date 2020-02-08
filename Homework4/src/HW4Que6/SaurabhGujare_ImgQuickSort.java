package HW4Que6;

public class SaurabhGujare_ImgQuickSort {
    int partition(double arr[], int low, int high)
    {
        double pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(double arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    void printArray(double[] array){
        for(int i=0;i<array.length;i++) {
            System.out.print(" "+array[i]+" ");
        }
    }

    public static void main(String[] args){
        SaurabhGujare_ImageData imgData = new SaurabhGujare_ImageData();
        double[] array = imgData.getIntensity();

        SaurabhGujare_ImgQuickSort obj = new SaurabhGujare_ImgQuickSort();
        System.out.println("The array before sort");
        obj.printArray(array);
        obj.sort(array,0,array.length-1);
        System.out.println("\n\nThe array after quick sort");
        obj.printArray(array);
    }
}
