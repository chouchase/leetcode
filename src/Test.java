import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String,List<String>> map = new TreeMap<>(((o1, o2) -> {
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            for(int i = 0; i < o1.length(); i ++){
                arr1[o1.charAt(i) - 'a'] ++;
            }
            for(int i = 0; i < o2.length(); i ++){
                arr2[o2.charAt(i) - 'a'] ++;
            }
            for(int i = 0; i < 26; i ++){
                if(arr1[i] != arr2[i]){
                    return arr1[i] - arr2[i];
                }
            }
            return 0;
        }));
        for(int i = 0; i < strs.length; i ++){
            if(!map.containsKey(strs[i])){
                map.put(strs[i],new ArrayList<>());
            }
            map.get(strs[i]).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();

        for(List<String> list : map.values()){
            res.add(list);
        }
        return res;
    }
}
public class Test {
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        new Solution().wiggleMaxLength(nums);

    }
}
