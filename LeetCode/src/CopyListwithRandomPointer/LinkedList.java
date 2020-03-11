package CopyListwithRandomPointer;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
};

public class LinkedList {
    private Node head = null;

    public LinkedList(){
    }

    public void add(int val){
        Node node = new Node(val);

        if(this.head==null){
            this.head = node;
        }else{
            Node last = this.head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = node;

        }
    }

    public void displayList(Node head){
        Node curNode  = head;
        while(curNode!=null){
            System.out.print(curNode.val+"-->");
            curNode = curNode.next;
        }
        System.out.print("null\n");
    }

    public void copyLinkedList(){
        displayList(this.head);

        Node newHead = this.head;
        Node newCurrNode = newHead;
        Node currNode = this.head;

        while(currNode.next!=null){
            currNode = currNode.next;
            newCurrNode.next = new Node(currNode.val);
            newCurrNode = newCurrNode.next;
        }
        displayList(newHead);
    }

    public static void main(String[] args){
        LinkedList list  =new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.copyLinkedList();
    }

}
