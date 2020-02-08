package heapSort;

public class HeapSort {


    public static void heapify(int[] array, int n, int i){
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

            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;

            heapify(array,n,largest);
        }

    }

    public void heapSort(int[] array, int n){

        //Create Heap
        for(int i=n/2-1;i>=0;i--){
            heapify(array,n,i);
        }


        //Extract element one-by-one from heap
        for(int i=n-1;i>=0;i--){
            //swap root and current node
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //heapify from current till root
            heapify(array,i,0);
        }

    }

    public static void main(String[] args){
        int[] array={121, 10, 130, 57, 36, 17};
        int n = array.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(array, n);

        for(int i=0; i<array.length;i++){
            System.out.print(array[i]+" ");
        }

    }
}
