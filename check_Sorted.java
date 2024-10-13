public class check_Sorted {
    
    public static Boolean check(int arr[], int n) {
        if (n == arr.length - 1) {
            return true;
        }
        if (arr[n + 1] < arr[n]) {
            return false;
        }
        return check(arr, n + 1);
    }

    public static void main(String args[]) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] arr2 = { 1, 2, 4, 3, 5, 6, 7, 8 };
        System.out.println(check(arr1, 0));
        System.out.println(check(arr2,0));
    }
}
