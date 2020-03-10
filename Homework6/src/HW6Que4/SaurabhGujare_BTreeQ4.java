package HW6Que4;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class SaurabhGujare_BTreeQ4 {

    class BTreeNode {
        char keys[];
        int t;
        BTreeNode[] C;
        int n;
        boolean leaf;

        public BTreeNode(int t1, boolean leaf1) {
            t = t1;
            leaf = leaf1;
            keys = new char[2 * t - 1];
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

        BTreeNode search(char k) {
            int i = 0;
            while (i < n && k > keys[i])
                i++;
            if (keys[i] == k)
                return this;
            if (leaf == true)
                return null;
            return C[i].search(k);
        }

        private void insertNonFull(char k) {
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

        int findKey(char k) {
            int idx = 0;
            while (idx < n && keys[idx] < k)
                ++idx;
            return idx;
        }

        void remove(char k) {
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
                keys[idx] = (char)pred;
                C[idx].remove((char)pred);
            }
            else if (C[idx + 1].n >= t) {
                int succ = getSucc(idx);
                keys[idx] = (char) succ;
                C[idx + 1].remove((char)succ);
            }
            else {
                merge(idx);
                C[idx].remove((char)k);
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

    SaurabhGujare_BTreeQ4(int t) {
        this.t = t;
    }

    void traverse() {
        if (root != null)
            root.traverse();
    }

    BTreeNode search(char k) {
        return (root == null) ? null : root.search(k);
    }

    private void insert(char k) {
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

    private void remove(char k) {
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
        SaurabhGujare_BTreeQ4 t = new SaurabhGujare_BTreeQ4(2); // A B-Tree with minimum degree t=2 or order m = 3
        
        char[] array = {'A','G','F','B','K','D','H','M','J','E','S','I','R','X','C','L','N','T','U','P'};
        for (char ele: array)
            t.insert(ele);

        System.out.println(" \n\nTraversal of tree constructed is\n");
        t.traverse();

        t.remove('G');
        System.out.println(" \n\nTraversal of tree after removing G\n");
        t.traverse();

        t.remove('L');
        System.out.println(" \n\nTraversal of tree after removing L\n");
        t.traverse();

        t.remove('D');
        System.out.println(" \n\nTraversal of tree after removing D\n");
        t.traverse();

    }
}