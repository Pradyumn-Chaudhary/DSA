public class Quick_Sort {
    public static void quick(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quick(arr, low, pi - 1);
            quick(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        //swap with pivot
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;

        return i;
    }
    
    public static void main(String args[]) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
