package leetcode.no5654;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = lowLimit; i <= highLimit; i ++){
            int key = 0;
            int t = i;
            while(t != 0){
                key += t % 10;
                t /= 10;
            }
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key,map.get(key) + 1);
            }
        }
        int res = 0;
        for(int e : map.values()){
            res = Math.max(res, e);
        }
        return res;
    }
}
