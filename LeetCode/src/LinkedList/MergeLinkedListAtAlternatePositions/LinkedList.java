package LinkedList.MergeLinkedListAtAlternatePositions;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {
    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    /* Inserts a new Node at front of the list. */
    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist1 = new LinkedList();
        LinkedList llist2 = new LinkedList();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);

        System.out.println("First Linked List:");
        llist1.printList();

        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);

        System.out.println("Second Linked List:");
        llist2.printList();

        llist1.merge(llist2);

        System.out.println("Modified first linked list:");
        llist1.printList();

        System.out.println("Modified second linked list:");
        llist2.printList();
    }

    private void merge(LinkedList q) {
        Node pt1 = head, pt2 = q.head;

        while(pt1!=null && pt2!=null){
            Node temp1 = pt1.next;
            Node temp2 = pt2.next;

            pt2.next = pt1.next;
            pt1.next = pt2;

            pt1 = temp1;
            pt2 = temp2;
        }

        q.head = pt2;


    }
}
