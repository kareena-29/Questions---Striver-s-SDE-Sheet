package Day_2;

import java.util.ArrayList;

public class Find_Duplicates_In_Array {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        int slow = arr.get(0);
        int fast = arr.get(0);

        do {
            fast = arr.get(arr.get(fast));
            slow = arr.get(slow);
        } while (slow != fast);

        fast = arr.get(0);
        while (slow != fast) {
            slow = arr.get(slow);
            fast = arr.get(fast);
        }

        return slow;

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(findDuplicate(arr, arr.size()));
    }
}
