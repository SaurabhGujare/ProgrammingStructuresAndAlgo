package HW5Que3_a;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_Binarytree {
    class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    Node root = null;

    public SaurabhGujare_Binarytree() {
        this.root = null;
    }

    public void add(int value){
        this.root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.key) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.key) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void search(int key){
        if(findElement(this.root,key))
            System.out.println("\n"+key+" is present inside the treee");
        else
            System.out.println("\n"+key+" is not present inside the tree");

    }

    private boolean findElement(Node current, int key){
        if(current == null)
            return false;
        if(current.key == key)
            return true;

        return key<current.key?findElement(current.left,key):findElement(current.right,key);
    }

    public void displayTree(){
        System.out.println("Displaying tree Inorder Traversal");
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node node){
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }


    public static void main(String[] args){
        SaurabhGujare_Binarytree binaryTree = new SaurabhGujare_Binarytree();

        System.out.println(" \nAdding:->\n");
        binaryTree.add(3);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.add(23);
        binaryTree.add(45);
        binaryTree.add(1);
        binaryTree.add(5);
        binaryTree.add(14);
        binaryTree.add(55);
        binaryTree.add(24);
        binaryTree.add(13);
        binaryTree.add(11);
        binaryTree.add(8);
        binaryTree.add(19);
        binaryTree.add(4);
        binaryTree.add(31);
        binaryTree.add(35);
        binaryTree.add(56);
        binaryTree.displayTree();
    }
}
