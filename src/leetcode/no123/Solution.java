package leetcode.no123;

class Solution {
    public int maxProfit(int[] prices) {
        /*int[][] sell = new int[prices.length][3];
        int[][] buy = new int[prices.length][3];
        sell[0][1] = Integer.MIN_VALUE >> 1;
        sell[0][2] = Integer.MIN_VALUE >> 1;
        buy[0][1] = Integer.MIN_VALUE >> 1;
        buy[0][2] = Integer.MIN_VALUE >> 1;
        buy[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0],-prices[i]);
            for (int j = 1; j <= 2; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Math.max(Math.max(sell[prices.length - 1][0],sell[prices.length - 1][1]),sell[prices.length - 1][2]);*/
        int[][] sell = new int[2][3];
        int[][] buy = new int[2][3];
        sell[0][1] = Integer.MIN_VALUE >> 1;
        sell[0][2] = Integer.MIN_VALUE >> 1;
        buy[0][1] = Integer.MIN_VALUE >> 1;
        buy[0][2] = Integer.MIN_VALUE >> 1;
        buy[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[1][0] = Math.max(buy[0][0],-prices[i]);
            for (int j = 1; j <= 2; j++) {
                buy[1][j] = Math.max(buy[0][j], sell[0][j] - prices[i]);
                sell[1][j] = Math.max(sell[0][j], buy[0][j - 1] + prices[i]);
            }
            int[] t = sell[1];
            sell[1] = sell[0];
            sell[0] = t;
            t = buy[0];
            buy[0] = buy[1];
            buy[1] = t;
        }
        return Math.max(Math.max(sell[1][0],sell[1][1]),sell[ 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        new Solution().maxProfit(prices);
    }
}
