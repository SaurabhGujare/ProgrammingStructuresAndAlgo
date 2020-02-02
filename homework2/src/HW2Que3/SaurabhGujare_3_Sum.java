/*
* 3. Write the code that results to the following running time. The 3-Sum Triple loop has
* the following running time estimate. Do Not prove Math. Just want explaining the math,
* what it represents and why the result is 1/6 N^3
* Saurabh Gujare
* NUID. 001424874
*/
package HW2Que3;

public class SaurabhGujare_3_Sum {
    public void threeSum(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        System.out.println("The numbers whose sum is equal to zero are");
                        System.out.println(array[i] + " " + array[j] + " " + array[k]);
                        return;
                    }
                }
            }
        }
        System.out.println("The numbers whose sum is equal to zero are not present");
    }

    public static void main(String[] args){
        int[] array = {7,3,6,1,-8};
        SaurabhGujare_3_Sum obj = new SaurabhGujare_3_Sum();
        obj.threeSum(array);
    }
}
