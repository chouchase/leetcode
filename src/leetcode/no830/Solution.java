package leetcode.no830;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 1; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == s.charAt(end)){
                end ++;
            }else{
                if(end - start + 1 >=  3){
                    List<Integer> t = new ArrayList<>(2);
                    t.add(start);
                    t.add(end);
                    res.add(t);
                }
                start = i;
                end = i;
            }
        }
        if(end - start + 1 >=  3){
            List<Integer> t = new ArrayList<>(2);
            t.add(start);
            t.add(end);
            res.add(t);
        }
        return res;
    }
}
