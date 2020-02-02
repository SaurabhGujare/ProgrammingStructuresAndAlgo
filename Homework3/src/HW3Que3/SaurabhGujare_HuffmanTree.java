package HW3Que3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.data-y.data;
    }
}

public class SaurabhGujare_HuffmanTree {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        char[] charArray = { 'e', 'f', 'n', 'o', 'q', 'u', 'w', 'z', 'a', 'd', 'r', 'h', 'i', 'T', 's', '/' };
        int[] charfreq = { 1,1,1,1,1,1,1,1,2,2,2,2,2,3,4,5 };
        int n=charArray.length;

        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for(int i=0;i<n;i++){
            HuffmanNode hn = new HuffmanNode();

            hn.data = charfreq[i];
            hn.c = charArray[i];
            hn.left = hn.right = null;

            q.add(hn);
        }

        HuffmanNode root = new HuffmanNode();

        while(q.size()>1){
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();

            f.data = x.data + y.data;
            f.c = '-';

            f.left = x;

            f.right = y;

            root = f;

            q.add(f);

        }

        printCode(root,"");
    }

    private static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            System.out.println(root.c + " : " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

}