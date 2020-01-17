/*
 * Find triplets in array whose sum is equal to a given number.
 * Order of Growth: cubic
 * Time Complexity: O(N) = N^3
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que4;

public class FindTriplets {

    public static void main (String[] args)
    {
        int arr[] = {0, -1, 2, -3, 1};
        int len = arr.length;
        findTriplets(arr, len, -2);
    }

    static void findTriplets(int arr[],
                             int len, int sum)
    {
        for (int i = 0; i < len - 2; i++)
        {
            for (int j = i + 1; j < len - 1; j++)
            {
                for (int k = j + 1; k < len; k++)
                {
                    if (arr[i] + arr[j] + arr[k] == sum)
                    {
                        System.out.println(arr[i]+ " "+ arr[j] +" "+ arr[k] );
                    }
                }
            }
        }
    }
}
