package leetcode.no330;
//
class Solution {
    public int minPatches(int[] nums, int n) {
        int border = 1;
        int index = 0;
        int res = 0;
        while(border <= n){
            if(index < nums.length){
                if(nums[index] <= border){
                    border = border + nums[index];
                    index ++;
                }else{
                    res ++;
                    border <<= 1;
                }
            }else{
                res ++;
                border <<= 1;
            }

        }
        return res;
    }
}
