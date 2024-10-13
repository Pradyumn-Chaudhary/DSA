public class revome_Duplicate {

    public static Boolean[] Map = new Boolean[26];

    public static String remove_duplicate(String str,int idx,String newString) {
        if (idx == str.length()) {
            return newString;
        }
        
        int n = str.charAt(idx)-'a';
        if (Map[n] == false) {
            newString += str.charAt(idx);
            Map[n] = true;
        }
        
        return remove_duplicate(str, idx + 1,newString);
    }

    public static void main(String args[]) {
        String str = "abbccda";
        for (int i = 0; i < 26; i++) {
            Map[i] = false;
        }
        String newString = remove_duplicate(str, 0, "");
        System.out.println(newString);
    }
}
