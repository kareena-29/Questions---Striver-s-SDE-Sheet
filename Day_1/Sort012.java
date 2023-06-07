package Day_1;

public class Sort012 {
    static void swap(int[] arr, int i, int j) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }

    public static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid++, low++);
            }

            else if (arr[mid] == 2) {
                swap(arr, mid, high--);
            } else {
                mid++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 1, 0, 2, 2, 2, 0, 1, 1, 1, 0 };
        sort012(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
