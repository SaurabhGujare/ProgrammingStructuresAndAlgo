package HW4Que1;

public class SaurabhGujare_SelectionSort {

    public static void selectionSort(int[] array){
        int n = array.length;

        for(int i=0;i<n-1;i++){
            int minNumIndex=i;
            for(int j=i+1;j<n;j++){
                if(array[minNumIndex]>array[j]){
                    minNumIndex = j;
                }
            }
            //Swap minimum element
            int temp = array[minNumIndex];
            array[minNumIndex] = array[i];
            array[i] = temp;
            System.out.println("\n\nStep "+(i+1)+": ");
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
        selectionSort(array);
        System.out.println("\n\nSorted Array Using Selection Sort :-");
        printArray(array);


    }
}
