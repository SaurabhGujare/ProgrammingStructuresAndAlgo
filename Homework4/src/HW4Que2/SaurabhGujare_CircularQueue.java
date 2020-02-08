package HW4Que2;

public class SaurabhGujare_CircularQueue {

    private int  MAX_SIZE ;
    private int[] array ;
    private int head, tail;

    public SaurabhGujare_CircularQueue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.array = new int[this.MAX_SIZE];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(int element){
        if(isFull()){
            System.out.println("\nThe queue is Full");
        }else{
            if(this.head==-1)
                this.head = 0;

            this.tail = (this.tail+1)%this.MAX_SIZE;
            this.array[this.tail] = element;
            System.out.println("the element "+element+" is enqueued");
        }

    }

    public void dequeue(){
        int temp;

        if(isEmpty()){
            System.out.println("\nThe queue is Empty");
        }else{
            temp = this.array[head];
            if(this.head == this.tail){
                this.head = -1;
                this.tail=  -1;
                System.out.println("\nThe only element "+temp+" inside the queue is dequeued. The queue is now empty");
            }else{
                this.head = (this.head+1)%this.MAX_SIZE;
                System.out.println("\nThe element "+temp+" is dequeued");
            }
        }

    }

    public boolean isFull(){

        if(this.head==0 && this.tail==this.MAX_SIZE-1)
            return true;
        else if(this.head == this.tail+1)
            return true;

        return false;
    }

    public boolean isEmpty(){
        if(this.head==-1)
            return true;

        return false;
    }

    public void displayQueue(){
        if(isEmpty())
            System.out.println("\nThe queue is Empty");
        else{

            System.out.println("\nThe Circular queue is");
            System.out.print("Head<--");
            for(int i = this.head; i != this.tail; i= (i+1)%this.MAX_SIZE){
                System.out.print(this.array[i]+" <-- ");
            }
            System.out.println(this.array[this.tail]+" <-- Tail");
        }
    }

    public int size(int head, int tail){
        if(tail>=head)
            return tail-head+1;
        else
            return this.MAX_SIZE-(head-tail)+1;
    }

    public static void main(String[] args){

        SaurabhGujare_CircularQueue circularQueue = new SaurabhGujare_CircularQueue(10);
        System.out.println("i) enqueue all input data");
        circularQueue.enqueue(12);
        circularQueue.enqueue(17);
        circularQueue.enqueue(38);
        circularQueue.enqueue(3);
        circularQueue.enqueue(9);
        circularQueue.enqueue(82);
        circularQueue.enqueue(10);
        circularQueue.enqueue(31);
        circularQueue.enqueue(24);
        circularQueue.enqueue(31);

        circularQueue.displayQueue();

        System.out.println("\n\nii) dequeue three elements");
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.displayQueue();

        System.out.println("\n\niii) enqueue two elements");
        circularQueue.enqueue(100);
        circularQueue.enqueue(110);

        circularQueue.displayQueue();

        System.out.println("\n\niv) dequeue all elements");
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();

        circularQueue.displayQueue();

    }
}
