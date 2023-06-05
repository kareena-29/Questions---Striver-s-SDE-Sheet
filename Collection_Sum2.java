import java.util.ArrayList;
import java.util.Collections;

public class Collection_Sum2 {

    public static void findCombinations(int index, ArrayList<Integer> arr, int target,
            ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if (i > index && arr.get(i) == arr.get(i - 1))
                continue;
            if (arr.get(i) > target)
                break;

            ds.add(arr.get(i));
            // i+1 not index+1
            findCombinations(i + 1, arr, target - arr.get(i), ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        findCombinations(0, arr, target, ans, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);

        ArrayList<ArrayList<Integer>> temp = combinationSum2(arr, 5, 4);

        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.get(i).size(); j++) {
                System.out.print(temp.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}