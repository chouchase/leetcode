package leetcode.no189;

public class Solution {

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        k %= nums.length;
        int cnt = 0;
        for(int i = 0; cnt < nums.length; i ++){
            int t = nums[i];
            int next = (i + k) % nums.length;
            while(cnt < nums.length){
                int tt = nums[next];
                nums[next] = t;
                t = tt;
                cnt ++;
                if(next == i) break;
                next = (next + k) % nums.length;

            }
        }

    }
}
