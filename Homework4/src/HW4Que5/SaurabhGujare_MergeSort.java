package HW4Que5;

public class SaurabhGujare_MergeSort {

    void mergeArray(int[] array, int left, int mid, int right){

        //Calculate the length of two arrays
        int sl = mid - left + 1;
        int sr = right - mid;
        
        //Create toe arrays
        int[] leftArray = new int[sl];
        int[] rightArray = new int[sr];

        //Split elements in those two new arrays
        for(int i=0; i<sl; ++i){
            leftArray[i] = array[left+i];
        }
        
        for(int j=0;j<sr;++j){
            rightArray[j] = array[mid+1+j];
        }
        
        //Compare elements and store it in the array
        int lPointer=0, rPointer=0, mainPointer=left;
        
        while(lPointer < sl && rPointer < sr){

            if(leftArray[lPointer]<=rightArray[rPointer]){
                array[mainPointer] = leftArray[lPointer];
                lPointer+=1;
            }else
            {
                array[mainPointer] = rightArray[rPointer];
                rPointer+=1;
            }
            mainPointer+=1;
            
        }

        //Make sure to store the elements  of the non-exhausted arrays
        while(lPointer<sl){
            array[mainPointer] = leftArray[lPointer];
            lPointer+=1;
            mainPointer+=1;
        }

        while(rPointer<sr){
            array[mainPointer] = rightArray[rPointer];
            rPointer+=1;
            mainPointer+=1;
        }

    }

    void splitAndMerge(int[] array, int left, int right){

        if(left<right){
            int mid = (left+right)/2;

            splitAndMerge(array,left,mid);

            splitAndMerge(array,mid+1,right);

            mergeArray(array,left,mid,right);
        }

    }

    void printArray(int[] array){
        for(int i=0;i<array.length;i++) {
            System.out.print(" "+array[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] array = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8};
        SaurabhGujare_MergeSort ob = new SaurabhGujare_MergeSort();

        System.out.println("Array before sort: ");
        ob.printArray(array);

        ob.splitAndMerge(array,0,array.length-1);

        System.out.println("\nArray after MergeSort: ");
        ob.printArray(array);

    }
}
