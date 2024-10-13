public class Occurance {
    public static int first = -1;
    public static int last = -1;

    public static void findOccurance(String str, int idx, char el) {
        if (idx == str.length()) {
            if (last == -1) {
                last = first;
            }
            System.out.println(first);
            System.out.println(last);
            return;
        }
        if (str.charAt(idx) == el) {
            if (first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }
        findOccurance(str, idx + 1, el);
    }

    public static void main(String[] args) {
        String str = "abaacdaefaah";
        findOccurance(str, 0, 'a');
    }
}