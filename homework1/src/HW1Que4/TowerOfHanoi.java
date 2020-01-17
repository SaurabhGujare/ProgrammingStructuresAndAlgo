/*
 * Tower of Hanoi
 * Order of Growth: Exponential
 * Time Complexity: O(N) = 2^N
 * Saurabh Gujare
 * NUID. 001424874
 * */
package HW1Que4;

public class TowerOfHanoi {

    public static void main(String args[])
    {
        int n = 3;
        hanoi_problem(n, 'A', 'C', 'B');  // A, B and C are names of rods
    }

    static void hanoi_problem(int N, char fromStack, char toStack, char spareStack)
    {
        if (N<1) {
            return;
        }
        if (N>1) {
            hanoi_problem(N-1, fromStack, spareStack, toStack);
        }
        System.out.println("Move Disk "+N+" from Stack " + fromStack + " to Stack " + toStack);
        if (N>1) {
            hanoi_problem(N-1, spareStack, toStack, fromStack);
        }
    }
}
