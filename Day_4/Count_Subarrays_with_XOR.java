package Day_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Count_Subarrays_with_XOR {
    public static int subarraysXor(ArrayList<Integer> arr, int k) {
        int xr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        for (int i = 0; i < arr.size(); i++) {
            xr = xr ^ arr.get(i);
            int x = xr ^ k;
            if (map.containsKey(x))
                cnt += map.get(x);

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return cnt;
    }


    public static void main(String[] args) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(5);
        temp.add(3);
        temp.add(8);
        temp.add(3);
        temp.add(10);

        System.out.println(subarraysXor(temp, 8));
    }
}
