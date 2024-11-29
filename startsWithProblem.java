public class startsWithProblem {

    static class Node {
        Node children[];
        boolean eow;

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String str) {
        Node currNode = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (currNode.children[idx] == null) {
                currNode.children[idx] = new Node();
            }
            currNode = currNode.children[idx];
            if (i == str.length() - 1) {
                currNode.eow = true;
            }
        }
    }

    public static boolean startsWith(String Prefix) {
        Node currNode = root;
        for (int i = 0; i < Prefix.length(); i++) {
            int idx = Prefix.charAt(i) - 'a';
            if (currNode == null) {
                return false;
            }
            currNode = currNode.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = { "apple", "app", "mango", "man", "woman" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
    }
}
