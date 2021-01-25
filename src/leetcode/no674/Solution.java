package leetcode.no674;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = 1;
        int l = 0;
        while(l < nums.length){
            int r = l + 1;
            while(r < nums.length && nums[r] > nums[r - 1]){
                r ++;
            }
            res = Math.max(res,r - l);
            l = r;
        }
        return res;
    }
}
