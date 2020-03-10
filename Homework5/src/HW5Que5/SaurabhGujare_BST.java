package HW5Que5;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_BST {
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

    public SaurabhGujare_BST() {
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

    public void deleteMin(){
        deleteKey(minValue(this.root));
    }

    public void deleteMax(){
        deleteKey(maxValue(this.root));
    }

    void deleteKey(int key){
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key){
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else{
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    public int returnMaxValue(){
        return maxValue(this.root);
    }

    private int minValue(Node root){
        if (root == null)
            return Integer.MAX_VALUE;

        int res = root.key;
        int lres = minValue(root.left);
        int rres = minValue(root.right);

        if (lres < res)
            res = lres;
        if (rres < res)
            res = rres;
        return res;
    }

    private int maxValue(Node root){
        if (root == null)
            return Integer.MIN_VALUE;

        int res = root.key;
        int lres = maxValue(root.left);
        int rres = maxValue(root.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
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
        SaurabhGujare_BST binaryTree = new SaurabhGujare_BST();

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

        System.out.print("\n\nMaximum Element is:-> "+binaryTree.returnMaxValue());

    }
}
