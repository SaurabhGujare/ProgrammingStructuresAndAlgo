package LinkedList.CompareTwoStrings;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {
//    Node head;  // head of list
    static Node a, b;

    /* Node Class */
    static class Node {

        char val;
        Node next;

        // Constructor to create a new node
        Node(char d) {
            val = d;
            next = null;
        }
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        Node result = null;

        list.a = new Node('g');
        list.a.next = new Node('e');
        list.a.next.next = new Node('e');
        list.a.next.next.next = new Node('k');
        list.a.next.next.next.next = new Node('s');
        list.a.next.next.next.next.next = new Node('b');

        list.b = new Node('g');
        list.b.next = new Node('e');
        list.b.next.next = new Node('e');
        list.b.next.next.next = new Node('k');
        list.b.next.next.next.next = new Node('s');
        list.b.next.next.next.next.next = new Node('a');

        int value;
        value = list.compare(a, b);
        System.out.println(value);

    }

    private int compare(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return 1;
        }

        while(node1!=null && node2!=null && node1.val==node2.val){
            node1=node1.next;
            node2=node2.next;

        }

        if(node1!=null && node2!=null)
            return (node1.val>node2.val?1:-1);


        if(node1!=null && node2==null)
            return 1;


        if(node1==null && node2!=null)
            return -1;

        return 0;

    }
}
