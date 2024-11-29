/*
 1 -> Find all Suffix of the String
 2 -> Create a Trie from suffixes
   // Total number of Nodes of trie = Count of unit Prefixes
 3 -> Count Node of Trie
 */

public class countUniqueString {

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

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < 26; i++) {
            count += countNodes(root.children[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "ababa";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println("Total number of unique substring are:\n" + countNodes(root));
    }
 }