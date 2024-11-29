public class WordBreakProblem {

    static class Node {
        Node[] children;
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
    
    public static boolean WordBreak(String key){
        if (key.length() == 0) {
            return true;
        }
        Node currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (currNode.children[idx] != null) {
                currNode = currNode.children[idx];
                if (currNode.eow == true) {
                    if (WordBreak(key.substring(i + 1))) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile", "jaguar" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(WordBreak("ilikejaguar"));
        System.out.println(WordBreak("ilikejr"));
        System.out.println(WordBreak("ilikesamsung"));

    }
}
