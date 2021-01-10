package leetcode.no228;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }
        int left = nums[0];
        int right = nums[0];
        for(int i = 1; i <= nums.length; i ++){
            if(i < nums.length && nums[i] == right + 1){
                right ++;
            }else{
                if(left == right){
                    list.add(String.valueOf(left));
                }else{
                    list.add(left + "->" + right);
                }
                left = nums[i];
                right = nums[i];
            }
        }

        return list;
    }
}
