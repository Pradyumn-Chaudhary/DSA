public class Tower_of_Hanoi {

    public static void towerofHanoi(int n, String Source, String Helper, String Destination) {
        if (n == 1) {
            System.out.println(n + " Disk transfer from " + Source + " to " + Destination);
            return;
        }
        towerofHanoi(n - 1, Source, Destination, Helper);
        System.out.println(n + " Disk transfer from " + Source + " to " + Destination);
        towerofHanoi(n - 1, Helper, Source, Destination);
    }

    public static void main(String args[]) {
        int n = 3;
        towerofHanoi(n, "S","H" , "D");
    }
}
