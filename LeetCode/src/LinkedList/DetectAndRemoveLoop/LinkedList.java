package LinkedList.DetectAndRemoveLoop;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Function to print the linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }

    private int detectAndRemoveLoop(Node head) {

        Node slow = head, fast = head;
        while(slow != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                remove(slow,head);
                return 1;
            }
        }
        return 0;
    }

    private void remove(Node loop, Node head) {

        //count no of loop-nodes say "k"

        int count = 1;
        Node ptr1 = loop;
        Node ptr2 = loop;
        while(ptr1.next != ptr2){
            count++;
            ptr1 = ptr1.next;
        }

        //set ptr1 to head
        ptr1 = head;

        //set ptr2 to node which is at kth position from head
        ptr2 = head;
        for(int i=0;i<count;i++){
            ptr2 = ptr2.next;
        }

        //move ptr1 and ptr2 at same pace so that they will meet at the starting position of the loop
        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        //get pt2 to the last node of the loop
        while(ptr2.next!=ptr1)
            ptr2 = ptr2.next;

        //set ptr2 to null which will remove the loop
        ptr2.next= null;
    }
}
