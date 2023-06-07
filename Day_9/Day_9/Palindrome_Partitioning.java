package Day_9;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    static void solve(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                solve(i + 1, s, path, res);
                // backtracking step
                path.remove(path.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        solve(0, s, path, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = partition(s);

        for(int i=0; i<ans.size(); i++){
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
