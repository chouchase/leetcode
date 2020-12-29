package leetcode.reversePairs;

class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return sortAndCount(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int sortAndCount(int[] nums, int left, int right, int[] buffer) {
        if (right <= left) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int leftRes = sortAndCount(nums, left, mid, buffer);
        int rightRes = sortAndCount(nums, mid + 1, right, buffer);
        int lp = left;
        int rp = mid + 1;
        int res = 0;
        int p = 0;
        while (lp <= mid && rp <= right) {
            if (nums[lp] <= nums[rp]) {
                buffer[p++] = nums[lp++];
                res += rp - (mid + 1);
            } else {
                buffer[p++] = nums[rp++];
            }
        }
        while (lp <= mid) {
            buffer[p++] = nums[lp++];
            res += rp - (mid + 1);
        }
        while (rp <= right) {
            buffer[p++] = nums[rp++];
        }
        if (right - left + 1 >= 0) System.arraycopy(buffer, 0, nums, left, right - left + 1);
        return res + leftRes + rightRes;
    }
}
