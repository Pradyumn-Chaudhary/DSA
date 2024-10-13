public class Bubble_Sort {
    public static void main(String args[]) {
        int arr[] = { 7, 8, 3, 2, 1 };
        // for (int i = arr.length-1; i >= 0; i--) {
        //     for (int j = 0; j < i; j++) {
        //         if (arr[j] > arr[j + 1]) {
        //             int temp = arr[j + 1];
        //             arr[j + 1] = arr[j];
        //             arr[j] = temp;
        //         }
        //     }
        // }
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
            if(count == 0)
                break;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}