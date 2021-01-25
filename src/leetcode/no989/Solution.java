package leetcode.no989;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        int index = A.length - 1;
        ArrayDeque<Integer> res = new ArrayList<>();
        while(index > 0){
            int t = A[index --] + K % 10 + carry;
            K /= 10;
            carry = t / 10;
            t %= 10;
            res.push(t);
        }
        while(K != 0){
            int t = K % 10 + carry;
            K /= 10;
            carry = t / 10;
            t %= 10;
            res.push(t);
        }
        if(carry != 0){
            res.push(carry);
        }
        List<Integer> list = new ArrayList<>();
        while(!res.isEmpty()){
            list.add(res.pop());
        }
        return list;
    }
}
