package Day_7;

public class Trapping_RainWater {
    public static long getTrappedWater(long[] arr, int n) {
        int left = 0, right = n - 1;
        long res = 0;
        long leftMax = 0, rightMax = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax)
                    leftMax = arr[left];
                else
                    res += leftMax - arr[left];

                left++;
            } else {
                if (arr[right] >= rightMax)
                    rightMax = arr[right];
                else
                    res += rightMax - arr[right];

                right--;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        long[] arr = { 3, 0, 0, 2, 0, 4 };
        System.out.println(getTrappedWater(arr, arr.length));
    }
}
