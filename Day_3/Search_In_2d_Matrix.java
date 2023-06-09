package Day_3;


import java.util.ArrayList;

public class Search_In_2d_Matrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int start = 0;
        int row = mat.size();
        int col = mat.get(0).size();
        int end = row * col - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            int element = mat.get(mid / col).get(mid % col);
            if (element == target) {
                return true;
            }

            else if (element < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = start + (end - mid) / 2;
        }
        return false;
    }
}
