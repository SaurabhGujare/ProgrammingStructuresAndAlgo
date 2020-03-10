package HW6Que1c;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_BTreeQ1c {

    class BTreeNode {
        int keys[];
        int t;
        BTreeNode[] C;
        int n;
        boolean leaf;

        public BTreeNode(int t1, boolean leaf1) {
            t = t1;
            leaf = leaf1;
            keys = new int[2 * t - 1];
            C = new BTreeNode[2 * t];
            n = 0;
        }

        void splitChild(int i, BTreeNode y) {
            BTreeNode z = new BTreeNode(y.t, y.leaf);
            z.n = t - 1;

            for (int j = 0; j < t - 1; j++)
                z.keys[j] = y.keys[j + t];

            if (y.leaf == false) {
                for (int j = 0; j < t; j++)
                    z.C[j] = y.C[j + t];
            }

            y.n = t - 1;

            for (int j = n; j >= i + 1; j--)
                C[j + 1] = C[j];
            C[i + 1] = z;

            for (int j = n - 1; j >= i; j--)
                keys[j + 1] = keys[j];
            keys[i] = y.keys[t - 1];
            n = n + 1;
        }

        void traverse() {
            int i;
            for (i = 0; i < n; i++) {
                if (leaf == false)
                    C[i].traverse();
                System.out.print(" " + keys[i]);
            }

            if (leaf == false)
                C[i].traverse();
        }

        BTreeNode search(int k) {
            int i = 0;
            while (i < n && k > keys[i])
                i++;
            if (keys[i] == k)
                return this;
            if (leaf == true)
                return null;
            return C[i].search(k);
        }

        private void insertNonFull(int k) {
            int i = n - 1;

            if (leaf == true) {
                while (i >= 0 && keys[i] > k) {
                    keys[i + 1] = keys[i];
                    i--;
                }

                keys[i + 1] = k;
                n = n + 1;
            } else
            {
                while (i >= 0 && keys[i] > k)
                    i--;

                if (C[i + 1].n == 2 * t - 1) {
                    splitChild(i + 1, C[i + 1]);

                    if (keys[i + 1] < k)
                        i++;
                }
                C[i + 1].insertNonFull(k);
            }
        }

        int findKey(int k) {
            int idx = 0;
            while (idx < n && keys[idx] < k)
                ++idx;
            return idx;
        }

        void remove(int k) {
            int idx = findKey(k);

            if (idx < n && keys[idx] == k) {
                if (leaf)
                    removeFromLeaf(idx);
                else
                    removeFromNonLeaf(idx);
            } else {
                if (leaf) {
                    System.out.println("The key " + k+ " is does not exist in the tree\n");
                    return;
                }
                boolean flag = ((idx == n) ? true : false);
                if (C[idx].n < t)
                    fill(idx);
                if (flag && idx > n)
                    C[idx - 1].remove(k);
                else
                    C[idx].remove(k);
            }
            return;
        }
        void removeFromLeaf(int idx) {
            for (int i = idx + 1; i < n; ++i)
                keys[i - 1] = keys[i];
            n--;
            return;
        }
        void removeFromNonLeaf(int idx) {
            int k = keys[idx];
            if (C[idx].n >= t) {
                int pred = getPred(idx);
                keys[idx] = (int)pred;
                C[idx].remove((int)pred);
            }
            else if (C[idx + 1].n >= t) {
                int succ = getSucc(idx);
                keys[idx] = (int) succ;
                C[idx + 1].remove((int)succ);
            }
            else {
                merge(idx);
                C[idx].remove((int)k);
            }
            return;
        }
        int getPred(int idx) {
            BTreeNode cur = C[idx];
            while (!cur.leaf)
                cur = cur.C[cur.n];
            return cur.keys[cur.n - 1];
        }
        int getSucc(int idx) {
            BTreeNode cur = C[idx + 1];
            while (!cur.leaf)
                cur = cur.C[0];
            return cur.keys[0];
        }
        void fill(int idx) {
            if (idx != 0 && C[idx - 1].n >= t)
                borrowFromPrev(idx);
            else if (idx != n && C[idx + 1].n >= t)
                borrowFromNext(idx);
            else {
                if (idx != n)
                    merge(idx);
                else
                    merge(idx - 1);
            }
            return;
        }
        void borrowFromPrev(int idx) {

            BTreeNode child = C[idx];
            BTreeNode sibling = C[idx - 1];
            for (int i = child.n - 1; i >= 0; --i)
                child.keys[i + 1] = child.keys[i];
            if (!child.leaf) {
                for (int i = child.n; i >= 0; --i)
                    child.C[i + 1] = child.C[i];
            }
            child.keys[0] = keys[idx - 1];
            if (!leaf)
                child.C[0] = sibling.C[sibling.n];
            keys[idx - 1] = sibling.keys[sibling.n - 1];

            child.n += 1;
            sibling.n -= 1;

            return;
        }
        void borrowFromNext(int idx) {

            BTreeNode child = C[idx];
            BTreeNode sibling = C[idx + 1];

            child.keys[(child.n)] = keys[idx];
            if (!(child.leaf))
                child.C[(child.n) + 1] = sibling.C[0];
            keys[idx] = sibling.keys[0];
            for (int i = 1; i < sibling.n; ++i)
                sibling.keys[i - 1] = sibling.keys[i];
            if (!sibling.leaf) {
                for (int i = 1; i <= sibling.n; ++i)
                    sibling.C[i - 1] = sibling.C[i];
            }
            child.n += 1;
            sibling.n -= 1;
            return;
        }
        void merge(int idx) {
            BTreeNode child = C[idx];
            BTreeNode sibling = C[idx + 1];
            child.keys[t - 1] = keys[idx];
            for (int i = 0; i < sibling.n; ++i)
                child.keys[i + t] = sibling.keys[i];
            if (!child.leaf) {
                for (int i = 0; i <= sibling.n; ++i)
                    child.C[i + t] = sibling.C[i];
            }
            for (int i = idx + 1; i < n; ++i)
                keys[i - 1] = keys[i];
            for (int i = idx + 2; i <= n; ++i)
                C[i - 1] = C[i];
            child.n += sibling.n + 1;
            n--;
            return;
        }
    }

    BTreeNode root;
    int t;

    SaurabhGujare_BTreeQ1c(int t) {
        this.t = t;
    }

    void traverse() {
        if (root != null)
            root.traverse();
    }

    BTreeNode search(int k) {
        return (root == null) ? null : root.search(k);
    }

    private void insert(int k) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else
        {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.C[0] = root;
                s.splitChild(0, root);
                int i = 0;
                if (s.keys[0] < k)
                    i++;
                s.C[i].insertNonFull(k);
                root = s;
            } else
                root.insertNonFull(k);
        }
    }

    private void remove(int k) {
        if (root == null) {
            System.out.println("The tree is empty\n");
            return;
        }

        root.remove(k);
        if (root.n == 0) {
            if (root.leaf)
                root = null;
            else
                root = root.C[0];
        }
        return;
    }

    public static void main(String args[]) {
        SaurabhGujare_BTreeQ1c t = new SaurabhGujare_BTreeQ1c(4); // A B-Tree with minimum degree t=4 or order m = 7

        int[] array = {3,7,9,23,45,1,5,14,24,13,11,8,19,4,31,35,56,17,29,6,22};
        for (int ele: array)
            t.insert(ele);

        System.out.println(" \n\nTraversal of tree constructed is\n");
        t.traverse();

        t.remove(45);
        System.out.println(" \n\nTraversal of tree after removing 45\n");
        t.traverse();

        t.remove(11);
        System.out.println(" \n\nTraversal of tree after removing 11\n");
        t.traverse();

        t.remove(31);
        System.out.println(" \n\nTraversal of tree after removing 31\n");
        t.traverse();

    }
}
