public class single_pair {
    public static int invite(int n) {
        
        // if (n == 1) {
        //     return 1;
        // }
        // if (n == 2) {
        //     return 2;
        // }

        if (n <= 1) {
            return 1;
        }
        //Single Invitation
        int singleWays = invite(n - 1);

        //Pair Inviation
        int pairWays = invite(n - 2) * (n - 1);

        return singleWays + pairWays;
    }

    public static void main(String args[]) {
        int n = 4;
        int ways = invite(n);
        System.out.println(ways);
    }
}
