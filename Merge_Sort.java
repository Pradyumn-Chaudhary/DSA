public class Merge_Sort {
    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int arr[], int si, int mid, int ei) {
        int[] conquered_array = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                conquered_array[x++] = arr[idx1++];
            } else {
                conquered_array[x++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            conquered_array[x++] = arr[idx1++];
        }
        while (idx2 <= ei) {
            conquered_array[x++] = arr[idx2++];
        }
        for (int i = 0, j = si; i < conquered_array.length; i++, j++) {
            arr[j] = conquered_array[i];
        }
    }
    public static void main(String args[]) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        divide(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
