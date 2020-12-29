package leetcode.no188;

class Solution {
    public int maxProfit(int k, int[] prices) {
        /*if(prices.length <= 1 || k <= 0){
            return 0;
        }
        k = Math.min(k,prices.length >> 1);
        int[][] buy = new int[prices.length][k + 1];
        int[][] sell = new int[prices.length][k + 1];
        *//*for(int i = 1; i <= k; i ++){
            buy[0][i] = Integer.MIN_VALUE;
            sell[0][i] = Integer.MIN_VALUE;
        }*//*
        buy[0][1] = Integer.MIN_VALUE >> 1;
        sell[0][1] = Integer.MIN_VALUE >> 1;
        buy[0][0] = - prices[0];
        for(int i = 1; i < prices.length; i ++){
            int limit = Math.min((i + 1) >> 1,k);
            buy[i][0] = Math.max(- prices[i],buy[i - 1][0]);
            for(int j = 1; j <= limit; j ++){
                buy[i][j] = Math.max(buy[i - 1][j],sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j],buy[i - 1][j - 1] + prices[i]);
            }
        }
        int res = 0;
        for(int i = 0; i <= k; i ++){
            res = Math.max(res,sell[prices.length - 1][i]);
        }
        return res;*/
        //better

        if (prices.length <= 1 || k <= 0) {
            return 0;
        }
        k = Math.min(k, prices.length >> 1);
        int[][] buy = new int[2][k + 1];
        int[][] sell = new int[2][k + 1];
        /*for(int i = 1; i <= k; i ++){
            buy[0][i] = Integer.MIN_VALUE;
            sell[0][i] = Integer.MIN_VALUE;
        }*/
        buy[0][1] = Integer.MIN_VALUE >> 1;
        sell[0][1] = Integer.MIN_VALUE >> 1;
        buy[0][0] = -prices[0];
        int lastRow = 0;
        int curRow = 0;
        for (int i = 1; i < prices.length; i++) {
            lastRow = 1 - (i & 1);
            curRow = i & 1;
            int limit = Math.min((i + 1) >> 1, k);
            buy[curRow][0] = Math.max(-prices[i], buy[lastRow][0]);
            for (int j = 1; j <= limit; j++) {
                buy[curRow][j] = Math.max(buy[lastRow][j], sell[lastRow][j] - prices[i]);
                sell[curRow][j] = Math.max(sell[lastRow][j], buy[lastRow][j - 1] + prices[i]);
            }
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, sell[curRow][i]);
        }
        return res;
    }
}


