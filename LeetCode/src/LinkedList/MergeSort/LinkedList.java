package LinkedList.MergeSort;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {
    Node head = null;
    // node a, b;
    static class Node {
        int val;
        Node next;

        public Node(int val)
        {
            this.val = val;
        }
    }

    void push(int new_data)
    {
        /* allocate node */
        Node new_node = new Node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    // Utility function to print the linked list
    void printList(Node headref)
    {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args)
    {

        LinkedList li = new LinkedList();
        /*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }



    //Function to get the middle element of th linkedlist
    public static Node getMiddle(Node head){
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //Function to sort the linkeList
    private Node mergeSort(Node head) {
        // Base case : if head is null
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node middleNext = middle.next;

        //set middle's next to null
        middle.next = null;

        //Apply merge sort to the left
        Node left = mergeSort(head);

        //Apply merge sort to the right
        Node right = mergeSort(middleNext);

        //Merge the left and right list
        Node sortedList = sortedMerge(left,right);

        return sortedList;
    }

    //Function to merge the linked List
    Node sortedMerge(Node a, Node b){
        Node result = null;
         if(a == null)
             return b;

         if(b == null)
             return a;

         if(a.val < b.val){
             result = a;
             result.next = sortedMerge(a.next,b);
         }else{
             result = b;
             result.next = sortedMerge(a, b.next);
         }

        return result;
    }
}
