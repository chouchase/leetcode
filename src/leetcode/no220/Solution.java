package leetcode.no220;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1 || k == 0){
            return false;
        }
        int n = nums.length;
        long[] nums1 = new long[nums.length];
        for(int i = 0; i < n ; i ++){
            nums1[i] = nums[i];
        }
        TreeMap<Long,Integer> map = new TreeMap<>();
        for(int i = 1; i < k && i < n; i ++){
            mapPut(map,nums1[i]);
        }
        for(int i = 0; i < n; i ++){
            if(i != 0){
                mapDelete(map,nums1[i]);
            }
            if(i + k < n){
                mapPut(map,nums1[i + k]);
            }
            Long c = map.ceilingKey(nums1[i] - t);
            Long f = map.floorKey(nums1[i] + t);
            if(f != null && f >= nums1[i] - t){
                return true;
            }
            if(c != null && c <= nums1[i] + t){
                return true;
            }
        }
        return false;

    }
    private static void mapPut(TreeMap<Long,Integer> map ,Long x){
        if(!map.containsKey(x)){
            map.put(x,1);
        }else{
            map.put(x,map.get(x) + 1);
        }
    }
    private static void mapDelete(TreeMap<Long,Integer> map,Long x){
        Integer v = map.get(x);
        v --;
        if(v == 0){
            map.remove(x);
        }else{
            map.put(x,v);
        }
    }

    public static void main(String[] args) {
        int[]nums = {1,2};
        int k = 0, t = 1;
        boolean b = new Solution().containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }
}
