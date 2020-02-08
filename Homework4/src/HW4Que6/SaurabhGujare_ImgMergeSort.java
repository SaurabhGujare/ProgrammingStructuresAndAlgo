package HW4Que6;

public class SaurabhGujare_ImgMergeSort {
    void mergeArray(double[] array, int left, int mid, int right){

        //Calculate the length of two arrays
        int sl = mid - left + 1;
        int sr = right - mid;

        //Create toe arrays
        double[] leftArray = new double[sl];
        double[] rightArray = new double[sr];

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

    void splitAndMerge(double[] array, int left, int right){

        if(left<right){
            int mid = (left+right)/2;

            splitAndMerge(array,left,mid);

            splitAndMerge(array,mid+1,right);

            mergeArray(array,left,mid,right);
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

        SaurabhGujare_ImgMergeSort ob = new SaurabhGujare_ImgMergeSort();

        System.out.println("\n\nArray before sort: ");
        ob.printArray(array);

        ob.splitAndMerge(array,0,array.length-1);

        System.out.println("\n\nArray after MergeSort: ");
        ob.printArray(array);

    }
}
