package HW11Que01;
/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class MinHeapTester {
    public void runTests(){
        MinHeap<String> heap = new MinHeap<String>();
        heap.addElement("John");
        heap.addElement("Paul");
        heap.addElement("George");
        heap.addElement("Ringo");
        heap.addElement("Elmer");
        heap.addElement("Zorro");
        System.out.println(heap);
        heap.removeMax();
        System.out.println(heap);
    }
    public static void main(String[] args) {
        MinHeapTester mht = new MinHeapTester();
        mht.runTests();
    }
}

