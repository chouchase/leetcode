package leetcode.no189;

public class Solution1 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
    private void reverse(int[] nums,int left,int right){
        while(left < right){
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left ++;
            right --;
        }
    }
}
