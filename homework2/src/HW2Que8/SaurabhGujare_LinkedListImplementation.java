/*8. For the LinkedList implementation of Queue example I discussed in class,
write a TestLinkedListQueue class to test enqueue, dequeue,,
isEmpty and other operations as needed.
* Saurabh Gujare
* NUID: 001424874*/
package HW2Que8;

public class SaurabhGujare_LinkedListImplementation {

    private static class Node<T>{
        private final T data;
        private  Node  next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node first = null;
    private Node last =null;

    public boolean isEmpty(){
        return (first==null);
    }

    public <T> void addAtLast(T data){
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = first;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
            last.next = null;
        }
    }

    public <T> T removeFromFirst(){
        if(!isEmpty()){
            T temp = (T) first.data;
            first = first.next;
            return  temp;
        }
        return null;
    }

    public void displayList(){
        Node current = first;
        while(current != null){
            System.out.print(" <-- "+current.data);
            current = current.next;
        }
    }
}
