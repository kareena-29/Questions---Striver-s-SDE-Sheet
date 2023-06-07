package Day_1;

import java.util.ArrayList;

public class Best_Time_To_Buy_And_Sell_Stocks {
    public static int maximumProfit(ArrayList<Integer> prices) {
        int mini = prices.get(0);
        int maxProfit = 0;

        for (int i = 0; i < prices.size(); i++) {
            int cost = prices.get(i) - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices.get(i));
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(17);
        prices.add(20);
        prices.add(11);
        prices.add(9);
        prices.add(12);
        prices.add(6);

        System.out.println(maximumProfit(prices));
    }
}
