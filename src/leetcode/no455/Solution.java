package leetcode.no455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int pg = 0;
        int ps = 0;
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(pg < g.length && ps < s.length){
            if(g[pg] <= s[ps]){
                cnt ++;
                pg ++;
                ps ++;
            }else{
                ps ++;
            }
        }
        return cnt;
    }
}
