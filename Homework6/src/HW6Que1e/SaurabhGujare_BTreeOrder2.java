package HW6Que1e;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SaurabhGujare_BTreeOrder2<T extends Comparable<T>> implements Iterable<T> {
    class Record<T extends Comparable<T>> {
        List<T> key = new ArrayList<T>();
        List<Record<T>> children = new ArrayList<Record<T>>();

        boolean isLeaf() {
            return children.size() == 0;
        }

        boolean is4Record() {
            return key.size() == 3;
        }

        Record(T x) {
            key.add(x);
        }

        Record(T x, Record<T> left, Record<T> right) {
            key.add(x);
            children.add(left);
            children.add(right);
            children.add(null);
        }

        public String toString() {
            String answer = "[";
            for (int i = 0; i < key.size(); i++) {
                if (i != 0)
                    answer += ", ";
                if (children.size() != 0)
                    answer += children.get(i).toString();
                answer += key.get(i);
            }
            if (children.size() != 0)
                answer += children.get(children.size() - 2).toString();
            return answer + "]";
        }

        void getkey(List<T> iteratorList) {
            for (int i = 0; i < key.size(); i++) {
                if (children.size() != 0)
                    children.get(i).getkey(iteratorList);
                iteratorList.add(key.get(i));
            }
            if (children.size() != 0)
                children.get(children.size() - 2).getkey(iteratorList);
        }

        boolean add(T val) {
            if (isLeaf())
                return addToLeaf(val);
            else
                return addToInterior(val);
        }

        boolean addToLeaf(T x) {
            int cmp;
            for (int i = 0; i < key.size(); i++) {
                cmp = x.compareTo(key.get(i));
                if (cmp == 0)
                    return false;
                else if (cmp < 0) {
                    key.add(i, x);
                    return true;
                }
            }
            key.add(x);
            return true;
        }

        boolean addToInterior(T x) {
            int cmp;
            for (int i = 0; i <= key.size(); i++) {
                if (i == key.size())
                    cmp = -1;
                else
                    cmp = x.compareTo(key.get(i));
                if (cmp == 0)
                    return false;
                else if (cmp < 0) {
                    boolean retVal = children.get(i).add(x);
                    if (children.get(i).is4Record())
                        childIs4Record(i);
                    return retVal;
                }
            }
            return false;
        }

        void childIs4Record(int i) {
            System.out.println("childIs4Record " + i);
            System.out.println(this);
            Record<T> the4Record = children.get(i);
            System.out.println(the4Record);
            if (i == 2)
                key.add(children.get(i).key.get(1));
            else
                key.add(i, children.get(i).key.get(1));
            Record<T> newChild1, newChild2;
            if (children.get(i).isLeaf()) {
                newChild1 = new Record<T>(children.get(i).key.get(0));
                newChild2 = new Record<T>(children.get(i).key.get(2));
            } else {
                newChild1 = new Record<T>(children.get(i).key.get(0), children.get(i).children.get(0),
                        children.get(i).children.get(1));
                newChild2 = new Record<T>(children.get(i).key.get(2), children.get(i).children.get(2),
                        children.get(i).children.get(3));
            }
            children.remove(the4Record);
            children.add(i, newChild2);
            children.add(i, newChild1);
        }
    }

    Record<T> root;

    public SaurabhGujare_BTreeOrder2() {
        root = null;
    }

    public boolean add(T val) {
        if (root == null) {
            root = new Record<T>(val);
            return true;
        } else {
            boolean isNew = root.add(val);
            if (root.key.size() == 3) {
                System.out.println("Split " + val);
                Record<T> left, right;
                if (root.isLeaf()) {
                    left = new Record<T>(root.key.get(0));
                    right = new Record<T>(root.key.get(2));
                } else {
                    left = new Record<T>(root.key.get(0), root.children.get(0), root.children.get(1));
                    right = new Record<T>(root.key.get(2), root.children.get(2), root.children.get(3));
                }
                root = new Record<T>(root.key.get(1), left, right);
            }
            return isNew;
        }
    }

    public Iterator<T> iterator() {
        List<T> key = new ArrayList<T>();
        if (root != null)
            root.getkey(key);
        return key.iterator();
    }

    public static void main(String[] args) {
        SaurabhGujare_BTreeOrder2<Integer> set = new SaurabhGujare_BTreeOrder2<Integer>();
        int arr[]= {3,7,9,23,45,1,5,14,5,24,13,11,8,19,4,31,35,56,17,29,6,22};
        for(int i=0;i<arr.length;i++)
            System.out.println("add "+arr[i]+" " + set.add(arr[i]));
        System.out.println("Print " + set.root);
        System.out.println("Iterate");
        for (Integer i : set)
            System.out.print(i + " ");
        System.out.println();
    }
}
