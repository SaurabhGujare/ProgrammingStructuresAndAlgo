package HW4Que6;

public class SaurabhGujare_ImgHeapSort {
    public static void heapify(double[] array, int n, int i){
        int largest = i;//root node index
        int leftIndex = 2*i+1;
        int rightIndex = 2*i+2;

        //if largest is left node
        if(leftIndex<n && array[largest]<array[leftIndex]){
            largest = leftIndex;
        }

        //if largest is right node
        if(rightIndex<n && array[largest]<array[rightIndex]){
            largest = rightIndex;
        }

        //if largest is not root node
        if(largest != i){

            double temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;

            heapify(array,n,largest);
        }

    }

    public void heapSort(double[] array, int n){

        //Create Heap
        for(int i=n/2-1;i>=0;i--){
            heapify(array,n,i);
        }


        //Extract element one-by-one from heap
        for(int i=n-1;i>=0;i--){
            //swap root and current node
            double temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //heapify from current till root
            heapify(array,i,0);
        }

    }

    public static void main(String[] args){
        SaurabhGujare_ImageData imgData = new SaurabhGujare_ImageData();
        double[] array= imgData.getIntensity();
        int n = array.length;

        SaurabhGujare_ImgHeapSort ob = new SaurabhGujare_ImgHeapSort();
        long start = System. currentTimeMillis();
        ob.heapSort(array, n);
        long end = System. currentTimeMillis();
        System.out.println("\nTime to sort the Pixel array size of the image using heap sort is "+(end-start)+" ms");

    }
}
