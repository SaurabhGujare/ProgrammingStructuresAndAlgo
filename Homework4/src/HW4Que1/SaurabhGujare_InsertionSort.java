package HW4Que1;

public class SaurabhGujare_InsertionSort {

    public static void insertionSort(int[] array){
        int n = array.length;

        for(int i=1;i<n;i++){
            int key = array[i];
            int j = i-1;

            while(j>=0 && array[j]>key){
                array[j+1] = array[j];
                j-=1;
            }
            array[j+1] = key;
            System.out.println("\nSteps "+i+": ");
            printArray(array);
        }
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] array = {64,25,12,22,11};
        System.out.println("\nUnsorted Array :-");
        printArray(array);
        insertionSort(array);
        System.out.println("\n\nSorted Array Using Insertion Sort :-");
        printArray(array);
    }
}
