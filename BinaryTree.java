import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
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

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // public static int countNode(int count,Node root) {
    //     if (root == null) {
    //         return count;
    //     }
    //     count++;
    //     countNode(count,root.left);
    //     countNode(count,root.right);
    //     return count;
    // }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNode = countNode(root.left);
        int rightNode = countNode(root.right);

        return leftNode + rightNode + 1;
    }

    public static int sumOfNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightCal(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightCal(root.left);
        int rightHeight = heightCal(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Brute Force
    // public static int DiaCal(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int dia1 = DiaCal(root.left);
    //     int dia2 = DiaCal(root.right);
    //     int dia3 = heightCal(root.left) + heightCal(root.right) + 1;

    //     return Math.max(dia3,Math.max(dia1, dia2));

    // }

    
    static class TreeInfo {
        int height;
        int dia;

        TreeInfo(int height, int dia) {
            this.height = height;
            this.dia = dia;
        }
    }

    public static TreeInfo DiaCal(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = DiaCal(root.left);
        TreeInfo right = DiaCal(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.height + right.height + 1;

        int dia = Math.max(dia3, Math.max(dia1, dia2));

        TreeInfo myInfo = new TreeInfo(height, dia);
        return myInfo;
    }

    public static int sumatKthLevel(Node root, int k) {
        int sum = 0;
        int level = 1;
        Queue<Node> q = new LinkedList();
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                level++;
                if (q.isEmpty()) {
                    break;
                } 
                q.add(null);
            } else {
                if (level == k) {
                    sum = currNode.data + sum;
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        binaryTree tree = new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        // System.out.println(countNode(0,root));
        System.out.println(countNode(root));
        System.out.println(sumOfNode(root));
        System.out.println(heightCal(root));
        System.out.println(DiaCal(root).dia);
        System.out.println(sumatKthLevel(root, 2));
        System.out.println(sumatKthLevel(root,3));
    }
}