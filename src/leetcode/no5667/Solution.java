package leetcode.no5667;

public class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] sum = new long[n];
        for(int i = 1; i < n; i ++){
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        boolean[] res = new boolean[queries.length];
        int index = 0;
        for(int[] query : queries){
            int type = query[0];
            long day = query[1];
            long cap = query[2];
            if(sum[type] + candiesCount[type] - 1 >= day){
                if(cap * day >= sum[type] || sum[type] - cap * day < cap){
                    res[index] = true;
                }
            }
            index ++;
        }
        return res;
    }
}
