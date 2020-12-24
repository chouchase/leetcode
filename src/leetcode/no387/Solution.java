package leetcode.no387;


class Solution {
    public int firstUniqChar(String s) {
        int[] pos = new int[26];
        for(int i = 0; i < s.length(); i ++){
            int p = s.charAt(i) - 'a';
            if(pos[p] == -1) continue;
            if(pos[p] == 0){
                pos[p] = i + 1;
            }else{
                pos[p] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i ++){
            if(pos[i] != 0 && pos[i] != -1){
                min = Math.min(min,pos[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min - 1;
    }
}
