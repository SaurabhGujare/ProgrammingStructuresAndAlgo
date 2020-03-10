package HW5Que4;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_KeyIndexSort {
    void sort(char myArray[])
    {
        int n = myArray.length;
        char output[] = new char[n];

        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        for (int i=0; i<n; ++i)
            ++count[myArray[i]];

        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];

        for (int i = n-1; i>=0; i--)
        {
            output[count[myArray[i]]-1] = myArray[i];
            --count[myArray[i]];
        }

        for (int i = 0; i<n; ++i)
            myArray[i] = output[i];
    }

    public static void main(String args[])
    {
        SaurabhGujare_KeyIndexSort ob = new SaurabhGujare_KeyIndexSort();
        char myArr[] = {'a','b','d','c','e','d','d','f','c','a','b','b','e','e','e','c','c','e','f','d','d','a','a','a','f'};
        ob.sort(myArr);
        System.out.print("Sorted character array is : ");
        for (int i=0; i<myArr.length; ++i)
            System.out.print(myArr[i]);
    }
}
