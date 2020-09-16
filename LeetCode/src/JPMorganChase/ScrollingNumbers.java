package JPMorganChase;

import LinkedList.AddTwoNumbersII.LinkedList;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 * Here's the question below, similar to Magic Numbers. (If this problem is listed in Leetcode problems please do let me know)
 *
 * Scrolling Numbers
 * Programming challerge description:
 * You have been given a special kind of lock to open called a "Scrolling Combination Lock" The lock has 9 keys numbered from 1 to 9.
 * Additionally, there are two numbers printed beow the keys suggesting a range of values. To open the lock, you must enter all the numbers in the range
 * that are "Scatting Numbers"
 *
 * A Scrolling Number is a number that has two characterisitics:
 *
 * No digits repeat themselves.
 * All digits in the number "scroll" through themselves.
 * How To Scroll:
 *
 * Beginning with the leftmost digit, take that digit's value D and move D digits to the right. When scrolling, if the last digit of the number is reached,
 * wrap back to the leftmost digit as many times as needed to move to total of D digits. After scrolling to a new digit, repeat the process using
 * the new digits's value for D.
 *
 * A Scrolling Number will visit every digit exactly once and end at the leftmost digit.
 *
 * For example, consider the Scrolling Number 6231.
 *
 * Start with the digit 6.
 * Advance 6 steps, wrapping around once, to the digit 3.
 * From 3 advance to 2, again wrapping around once
 * From 2 advance to 1
 * From 1 advance to 6 in a final wrap
 * Input:
 * The input is the range of integers to consider for the lock, expressed in the format A, B
 * Each integer A and B is 1 <= A <= B <= 10000.
 *
 * Output:
 * Print all Scrolling Numbers between A and B inclusive, each on a single line. These are the combinations that will open the lock.
 *
 * If there are no Scrolling Numbers between A and B print -1.
 */
public class ScrollingNumbers {

    static class Node
    {
        int val;
        Node next;

        public Node(int val)
        {
            this.val = val;
        }
    }

    public static void findCombinations(int a, int b) {

    }

    private static Node buildCircularLinkedList(int num){
        int length = String.valueOf(num).length();

        Node tail = new Node(num%10);
        Node tempTail = tail;
        Node head = null;
        for(int i=0;i<length-1;i++){
            if(num==0) break;
            num = num/10;
            head = new Node(num%10);
            head.next = tempTail;
            tempTail = head;
        }
        tail.next = head;
        return head;
    }

    private static void displayLinkedList(Node head, int num){
        int length = String.valueOf(num).length();

        for(int i=0;i<length+3; i++){
            System.out.print("-->"+head.val+"-->");
            head = head.next;
        }

    }

    public static void main(String[] args){
        findCombinations(100, 500);

    }

}
