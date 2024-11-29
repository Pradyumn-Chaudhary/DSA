public class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];  //26 -> a to z
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

    public static boolean search(String str) {
        Node currNode = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (currNode.children[idx] == null) {
                return false;
            }
            currNode = currNode.children[idx];
        }
        return currNode.eow;
    }
    
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        String words[] = { "a", "any", "there", "the", "their" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.err.println(search("a"));
        System.out.println(search("any"));
        System.out.println(search("an"));
    }
}
