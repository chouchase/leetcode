package leetcode.no5665;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,Integer> map1 = new HashMap<>(adjacentPairs.length + 1);
        Map<Integer,Integer> map2 = new HashMap<>(adjacentPairs.length + 1);
        Map<Integer,Integer> map3 = new HashMap<>(adjacentPairs.length + 1);
        for(int[] arr : adjacentPairs){
            int x = arr[0];
            int y = arr[1];
            if(!map3.containsKey(x)){
                map3.put(x,1);
            }else{
                map3.put(x,map3.get(x) + 1);
            }
            if(!map3.containsKey(y)){
                map3.put(y,1);
            }else{
                map3.put(y,map3.get(y) + 1);
            }
            if(!map1.containsKey(x)){
                map1.put(x,y);
            }else{
                map2.put(x,y);
            }
            if(!map2.containsKey(y)){
                map2.put(y,x);
            }else{
                map1.put(y,x);
            }
        }
        int start = 0;
        for(int e : map3.keySet()){
            if(map3.get(e) == 1){
                start = e;
                break;
            }
        }
        int[] res = new int[adjacentPairs.length + 1];
        res[0] = start;
        int last = start;
        HashSet<Integer> set = new HashSet<>();
        set.add(start);
        for(int i = 1; i < res.length; i ++){
            int cur  = 0;
            if(map1.containsKey(last)){
                cur = map1.get(last);
                if(set.contains(cur)){
                    cur = map2.get(last);
                }
            }else{
                cur = map2.get(last);
            }

            res[i] = cur;
            last = cur;
            set.add(cur);
        }
        return res;
    }
}
