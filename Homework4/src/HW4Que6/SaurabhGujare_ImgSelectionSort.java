package HW4Que6;

public class SaurabhGujare_ImgSelectionSort {

    public static void selectionSort(double[] array){
        int n = array.length;

        for(int i=0;i<n-1;i++){
            int minNumIndex=i;
            for(int j=i+1;j<n;j++){
                if(array[minNumIndex]>array[j]){
                    minNumIndex = j;
                }
            }
            //Swap minimum element
            double temp = array[minNumIndex];
            array[minNumIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(double[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args){
        SaurabhGujare_ImageData imgData = new SaurabhGujare_ImageData();
        double[] array = imgData.getIntensity();
        System.out.println("\nUnsorted Array :-");
        printArray(array);
        selectionSort(array);
        System.out.println("\n\nSorted Array Using Selection Sort :-");
        printArray(array);


    }
}
