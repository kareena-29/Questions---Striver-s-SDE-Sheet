package Day_9;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum1 {
    public static void findCombinations(int index, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // pick the element
        if (candidates[index] <= target) {
            ds.add(candidates[index]);
            findCombinations(index, candidates, target - candidates[index], ans, ds);
            ds.remove(ds.size() - 1);
        }

        // not to pick the element
        findCombinations(index + 1, candidates, target, ans, ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = combinationSum(candidates, target);

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
