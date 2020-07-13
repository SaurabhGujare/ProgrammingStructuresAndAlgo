package LinkedList.UnionAndIntersection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Utility function to print list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*  Inserts a node at start of linked list */
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

    public static void main(String args[])
    {
        LinkedList llist1 = new LinkedList();
        LinkedList llist2 = new LinkedList();
        LinkedList union = new LinkedList();
        LinkedList intersecn = new LinkedList();

        /*create a linked lits 10->15->5->20 */
        llist1.push(20);
        llist1.push(4);
        llist1.push(15);
        llist1.push(10);

        /*create a linked lits 8->4->2->10 */
        llist2.push(10);
        llist2.push(2);
        llist2.push(4);
        llist2.push(8);

        intersecn.getIntersection(llist1.head, llist2.head);
        union.getUnion(llist1.head, llist2.head);

        System.out.println("First List is");
        llist1.printList();

        System.out.println("Second List is");
        llist2.printList();

        System.out.println("Intersection List is");
        intersecn.printList();

        System.out.println("Union List is");
        union.printList();
    }

    private LinkedList getUnion(Node head, Node head1) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        LinkedList result = new LinkedList();
        Node n1 = head;
        Node n2 = head1;

        while(n1 != null){
            if(hashMap.containsKey(n1.data)){
                hashMap.put(n1.data, hashMap.get(n1.data)+1);
            }else{
                hashMap.put(n1.data,1);
            }
            n1 = n1.next;
        }

        while(n2 != null){
            if(hashMap.containsKey(n2.data)){
                hashMap.put(n2.data, hashMap.get(n2.data)+1);
            }else{
                hashMap.put(n2.data,1);
            }
            n2 = n2.next;
        }

        for(int val: hashMap.keySet()){
            result.push(val);
        }

        return result;
    }

    boolean  isPresent(Node head, int data){
        Node curr  = head;

        while(curr!=null){
            if(curr.data == data)
                return true;
            curr = curr.next;
        }
        return false;
    }

    private LinkedList getIntersection(Node head, Node head1) {

        Set<Integer> hashSet = new HashSet<>();
        LinkedList result = new LinkedList();
        Node n1 = head;
        Node n2 = head1;

        while(n1 != null){
            hashSet.add(n1.data);
            n1 = n1.next;
        }

        while(n2 != null){
            if(hashSet.contains(n2.data)){
                result.push(n2.data);
            }
            n2 = n2.next;
        }
    return result;
    }
}
