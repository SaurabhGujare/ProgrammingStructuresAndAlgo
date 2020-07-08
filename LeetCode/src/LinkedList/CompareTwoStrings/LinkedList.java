package LinkedList.CompareTwoStrings;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {
    static Node a, b;

    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
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

    private int compare(Node a, Node b) {
        Node head1 = a, head2 =b;

        while(head1!=null && head2!=null && head1.val==head1.val){
            head1=head1.next;
            head2=head2.next;
        }


    }
}
