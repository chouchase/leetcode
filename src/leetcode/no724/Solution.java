package leetcode.no724;

public class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = 0;
        for(int i = 1; i < nums.length; ++ i){
            right += nums[i];
        }
        if(left == right){
            return 0;
        }
        for(int i = 1; i < nums.length; i ++){
            left += nums[i - 1];
            right -= nums[i];
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
