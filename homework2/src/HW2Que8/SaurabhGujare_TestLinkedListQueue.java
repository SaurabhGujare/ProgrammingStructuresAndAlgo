/*8. For the LinkedList implementation of Queue example I discussed in class,
write a TestLinkedListQueue class to test enqueue, dequeue,,
isEmpty and other operations as needed.
* Saurabh Gujare
* NUID: 001424874*/
package HW2Que8;

public class SaurabhGujare_TestLinkedListQueue {

    SaurabhGujare_LinkedListImplementation linkedListObj = new SaurabhGujare_LinkedListImplementation();

    public SaurabhGujare_TestLinkedListQueue() {
    }

    public <T> void enqueue(T data){
        linkedListObj.addAtLast(data);
    }

    public <T> T dequeue(){
        return linkedListObj.removeFromFirst();
    }

    public void displayQueue(){
        linkedListObj.displayList();
    }

    public boolean isEmpty(){
        return linkedListObj.isEmpty();
    }

    public static void main(String[] args){

        SaurabhGujare_TestLinkedListQueue TestLinkedListQueue = new SaurabhGujare_TestLinkedListQueue();

        System.out.println("\n\nEnqueue operations performed");
        TestLinkedListQueue.enqueue("item1");
        TestLinkedListQueue.enqueue("item2");
        TestLinkedListQueue.enqueue("item3");
        TestLinkedListQueue.enqueue("item4");
        TestLinkedListQueue.enqueue("item5");

        System.out.println("\n\nDisplaying queue");
        TestLinkedListQueue.displayQueue();

        System.out.println("\n\nCheck if Queue is empty- "+TestLinkedListQueue.isEmpty());

        System.out.println("\n\nDequeue operation performed");
        TestLinkedListQueue.dequeue();
        TestLinkedListQueue.dequeue();
        TestLinkedListQueue.dequeue();
        TestLinkedListQueue.dequeue();
        TestLinkedListQueue.dequeue();

        System.out.println("\n\nCheck if Queue is empty- "+TestLinkedListQueue.isEmpty());

    }

}
