package miscellanea.leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{
                2, 9, 7, 1, 5, 3, 6, 4
//                2,9,7, 6, 4, 3, 1
        }));
    }

    public int maxProfit(int[] prices) {
        int bestProfit = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            }
            if (price - min > bestProfit){
                bestProfit = price - min;
            }
        }
        return bestProfit;
    }
}
