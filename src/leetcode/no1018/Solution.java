package leetcode.no1018;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        long t = 0;
        int n = A.length;
        List<Boolean> res = new ArrayList<>(n);
        for(int i = 0; i < n; i ++){
            t <<= 1;
            t |= A[i];
            if(t % 5 == 0){
                res.add(true);
            }else{
                res.add(false);
            }
            t %= 5;
        }
        return res;
    }
}
