public class LongestWordwithAllPrefixxes {

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

    public static String longestWord(Node root) {
        String longest = "";
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char currChar = (char) (i + 'a');
                String childWord = longestWord(root.children[i]);
                String currWord = currChar + childWord;

                if (currWord.length() > longest.length()) {
                    longest = currWord;
                }
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        String words[] = { "a", "ap", "banana", "apply", "app", "mango", "apple", "appl" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(longestWord(root));
    }
    
}
