package LinkedList.AddTwoNumbersII;

import java.util.Stack;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class LinkedList {

    class Node
    {
        int val;
        Node next;

        public Node(int val)
        {
            this.val = val;
        }
    }

    Node head1, head2, result;
    int carry;

    // Function to print linked list
    void printlist(Node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    /* A utility function to push a value to linked list */
    void push(int val, int list)
    {
        Node newnode = new Node(val);
        if (list == 1)
        {
            newnode.next = head1;
            head1 = newnode;
        }
        else if (list == 2)
        {
            newnode.next = head2;
            head2 = newnode;
        }
        else
        {
            newnode.next = result;
            result = newnode;
        }

    }

    public static void main(String args[])
    {
        LinkedList list = new LinkedList();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = { 1, 9, 9 };
        int arr2[] = { 1, 8 };

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);

        list.addlists();

        list.printlist(list.result);
    }

    private void addlists() {
        //create stacks
        Stack<Integer> stack1 =  new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //enter values in stack
        Node h1 = head1, h2 = head2;

        while(h1!=null){
            stack1.push(h1.val);
            h1=h1.next;
        }

        while(h2!=null){
            stack2.push(h2.val);
            h2=h2.next;
        }

        //calculate sums until stacks are empty
        result = new Node(0);
        int sum=0;
        int count = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            sum+= stack1.isEmpty()?0:stack1.pop();
            sum+=stack2.isEmpty()?0:stack2.pop();
            result.val = sum%10;
            Node carry = new Node(sum/10);
            carry.next = result;
            result = carry;
            sum/=10;
            count+=1;
        }

        if(result.val==0)
            result = result.next;

    }
}
