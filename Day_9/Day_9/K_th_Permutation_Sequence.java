package Day_9;

import java.util.ArrayList;
import java.util.List;

public class K_th_Permutation_Sequence {
    public static String kthPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        // (n-1)!
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }

        numbers.add(n);
        String ans = "";
        // as 0-indexing
        k = k - 1;
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = kthPermutation(4, 17);

        System.out.println(s);
    }
}
