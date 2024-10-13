public class Backtracking {
    public static void printPermutation(String str, int idx, String Permutation) {
        if (str.length() == 0) {
            System.out.println(Permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newstr, idx + 1, Permutation + currChar);
        }
    }

    public static void main(String args[]) {
        String str = "abc";
        printPermutation(str, 0, "");
    }
}

