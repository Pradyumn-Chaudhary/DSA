public class String_reverse {

    public static void reverse_string(String str, int n) {
        if (n == 0) {
            System.out.print(str.charAt(n));
            return;
        }
        System.out.print(str.charAt(n));
        reverse_string(str, n-1);
    }

    public static void main(String args[]) {
        String str = "Apna College";
        reverse_string(str,str.length()-1);
    }
    
}
