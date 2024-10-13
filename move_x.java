public class move_x {

    public static String moveX(String str,int idx,int count,String newString,char el)
    {
        if (idx == str.length()) {
            while (count-- > 0) {
                newString += el;
            }
            return newString;
        }
        if (str.charAt(idx) != el) {
            newString += str.charAt(idx);
        }
        else {
            count++;
        }
        return moveX(str, idx + 1, count, newString, el);
    }

    public static void main(String args[]) {
        String str = "axbcxxd";
        String newString = moveX(str, 0, 0, "", 'x');
        System.out.println(newString);
    }
}
