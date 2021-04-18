package leetcode.no26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        int last = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == last) continue;
            last = nums[i];
            nums[len ++] = last;
        }
        return len;

    }
}
