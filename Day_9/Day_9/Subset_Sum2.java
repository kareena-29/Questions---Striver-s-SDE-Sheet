package Day_9;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset_Sum2 {
    static void findSubset(int index, int[] nums, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);
            findSubset(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int nums[]) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        findSubset(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 3, 3 };
        ArrayList<ArrayList<Integer>> temp = uniqueSubsets(arr.length, arr);

        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                System.out.print(temp.get(i).get(j));
            }

            System.out.println();
        }
    }
}
