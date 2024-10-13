public class tilesFloor {
    public static int Placing(int n, int m) {
        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }

        //Vertical Placing
        int Vertical = Placing(n - m, m);
        
        //Horizontal Placing
        int Horizontal = Placing(n - 1, m);

        return Vertical+Horizontal;
    }
    public static void main(String args[]) {
        int ways = Placing(4, 2);
        System.out.println(ways);
    }
}
