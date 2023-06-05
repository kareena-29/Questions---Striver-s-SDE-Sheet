package Day_1;

public class Maximum_Subarray_Sum {
    public static long maxSubarraySum(int[] arr, int n) {
        long sum = 0;
        long maxi = 0;
        // int start = -1;
        // int ansstart = -1, ansend = -1;

        for (int i = 0; i < arr.length; i++) {
            // if(sum == 0){
            // start = i;
            // }
            sum = sum + arr[i];

            if (sum > maxi) {
                // ansstart = start;
                // ansend = i;
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        // System.out.println(ansstart);
        // System.out.println(ansend);
        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {-1, 1,4,5,6,-6,-3,-7,-8};
        System.out.println(maxSubarraySum(arr, arr.length));
    }
}
