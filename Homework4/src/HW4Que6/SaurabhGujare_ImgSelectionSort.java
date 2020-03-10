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

        long start = System. currentTimeMillis();
        selectionSort(array);
        long end = System. currentTimeMillis();
        System.out.println("\nTime to sort the Pixel array size of the image using Quick sort is "+(end-start)+" ms");



    }
}
