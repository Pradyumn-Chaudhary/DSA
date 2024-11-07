import java.util.*;

public class BinarySearchTree {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class binaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    //inOrder traversal of BST gives a sorted sequence
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //BST makes search efficient
    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val > target) {
            return search(root.left, target);
        } else if (root.val < target) {
            return search(root.right, target);
        } else {
            return true;
        }
    }

    public static Node insert(int value, Node root) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (root.val > value) {
            root.left = insert(value, root.left);
        } else {
            root.right = insert(value, root.right);
        }
        return root;
    }

    public static Node delete(Node root, int target) {
        if (root == null) {
            System.out.println("Target not exist in tree");
            return null;
        }

        if (root.val > target) {
            root.left = delete(root.left, target);
        } else if (root.val < target) {
            root.right = delete(root.right, target);
        } else {
            //case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            //case 2
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //case 3
            Node IS = inOrderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val >= x && root.val <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.val + " ");
            printInRange(root.right, x, y);
        } else if (root.val <= x) {
            printInRange(root.left, x, y);
        } else if (root.val >= y) {
            printInRange(root.right, x, y);
        }
    }
    
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("NULL");
    }
    public static void Root2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);

        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            Root2Leaf(root.left, path);
            Root2Leaf(root.right, path);
        }
        path.remove((path.size() - 1));
    }
    public static void main(String args[]) {
        int nodes[] = { 4, 2, 1, -1, -1, 3, -1, -1, 5, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        inOrder(root);
        System.out.println();
        System.out.println(search(root, 3));

        int[] values = { 5, 1, 3, 4, 2, 6 };
        Node Root = null;
        for (int i = 0; i < values.length; i++) {
            Root = insert(values[i], Root);
        }
        inOrder(Root);
        System.out.println();
        System.out.println(search(Root, 7));

        int[] values1 = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node Root1 = null;
        for (int i = 0; i < values1.length; i++) {
            Root1 = insert(values1[i], Root1);
        }
        inOrder(Root1);
        System.out.println();

        delete(Root1, 42);
        inOrder(Root1);
        System.out.println();

        printInRange(Root1, 3, 12);
        System.out.println();

        Root2Leaf(Root1, new ArrayList<>());
    }
}


