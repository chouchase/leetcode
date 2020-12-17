package leetcode.no714;

/**
 * 买卖股票的最佳时机含手续费
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        //dp解法一
        /*long[][] dp = new long[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i  = 1; i < prices.length; i ++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);

        }
        return (int)dp[prices.length - 1][0];*/
        //dp解法二
       /* int have = -prices[0];
        int noHave = 0;
        for(int i = 1; i < prices.length; i ++){
            int curHave = Math.max(have,noHave - prices[i]);
            int curNoHave = Math.max(noHave,have + prices[i] - fee);
            have = curHave;
            noHave = curNoHave;
        }
        return noHave;*/
        //贪心解法
        int buy = prices[0] +fee;
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(prices[i] + fee <buy){
                buy = prices[i] + fee;
            }else if(prices[i] > buy){
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
