package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int maximumScore(int[] nums, int k) {
        int min = nums[k];
        for(int i = k - 1; i >= 0; i --){
            min = Math.min(min,nums[i]);
            nums[i] = min;
        }
        min = nums[k];
        for(int i = k + 1; i < nums.length; i ++){
            min = Math.min(min,nums[i]);
            nums[i] = min;
        }
        int len = nums.length;
        int res = 0x80000000;
        int left = k - 1;
        int right = k + 1;
        while(left >= 0 && right < nums.length){
            while(left - 1 >= 0 && nums[left - 1] == nums[left]){
                left --;
            }
            while(right + 1 < nums.length && nums[right + 1] == nums[right]){
                right ++;
            }
            res = Math.max(res,Math.min(nums[left],nums[right]) * (right - left + 1));
            if(left > right){
                left --;
            }else{
                right ++;
            }
        }

        return Math.max(res,nums[k]);
    }

}
