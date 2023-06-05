package Day_9;

import java.util.ArrayList;
import java.util.Collections;

public class Subset_Sum {
    static void solve(int index, int sum, int[] num, int N, ArrayList<Integer> sumSubset) {
        if (index == N) {
            sumSubset.add(sum);
            return;
        }
        // pick the element
        solve(index + 1, sum + num[index], num, N, sumSubset);

        // not pick the element
        solve(index + 1, sum, num, N, sumSubset);
    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        int N = num.length;
        solve(0, 0, num, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<Integer> temp = subsetSum(arr);

        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i) + " ");
        }
    }
}
