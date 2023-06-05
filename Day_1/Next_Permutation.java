package Day_1;

import java.util.ArrayList;

public class Next_Permutation {
    static void swap(ArrayList<Integer> temp, int i, int j) {
        int x = temp.get(i);
        temp.set(i, temp.get(j));
        temp.set(j, x);
    }

    static void reverse(ArrayList<Integer> temp, int i, int j) {
        while (i < j) {
            swap(temp, i++, j--);
        }

    }

    public static void nextPermutation(ArrayList<Integer> permutation) {
        if (permutation.size() == 0 || permutation.size() == 1) {
            // return permutation;
            return;
        }
        int i = 0, j = 0;
        int n = permutation.size();

        i = n - 2;
        while (i >= 0 && permutation.get(i) >= permutation.get(i + 1)) {
            i--;
        }

        if (i >= 0) {
            j = n - 1;
            while (permutation.get(j) <= permutation.get(i)) {
                j--;
            }

            swap(permutation, i, j);
        }

        reverse(permutation, i + 1, n - 1);
        // return permutation;
    }
    public static void main(String[] args) {
        ArrayList<Integer> permutation = new ArrayList<>();
        permutation.add(1);
        permutation.add(3);
        permutation.add(5);
        permutation.add(4);
        permutation.add(2);

        nextPermutation(permutation);

        for (int i = 0; i < permutation.size(); i++) {
            System.out.print(permutation.get(i) + " ");
        }
    }
}
