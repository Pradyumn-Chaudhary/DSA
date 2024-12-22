public class RecursiveInsertionSort {

    public static void RecursiveInsertion(int arr[], int n) {
        if (n == arr.length) {
            return;
        }
        int j = n - 1;
        int key = arr[n];
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        RecursiveInsertion(arr, n + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        RecursiveInsertion(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
