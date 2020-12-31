package leetcode.no435;

import java.util.Arrays;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return 0;
        }
        Arrays.sort(intervals,((o1, o2) -> o1[1] - o2[1]));
        int tail = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i ++){
            if(intervals[i][0] < tail){
                ++res;
            }else{

                tail = intervals[i][1];
            }

        }
        return res;
    }
}