package leetcode.no239;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer>  stack = new ArrayDeque<>();
        for(int i = 0; i < k; i ++){
            addToStack(stack,nums[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(stack.getFirst());
        int left = 0;
        int right = k;
        while(right < nums.length){
            if(nums[left] == stack.getFirst()){
                stack.removeFirst();
            }
            left ++;
            addToStack(stack,nums[right]);
            right ++;
            list.add(stack.getFirst());
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i ++){
            res[i] = list.get(i);
        }
        return res;

    }
    private void addToStack(ArrayDeque<Integer> stack, int elem){
        while(!stack.isEmpty() && elem > stack.getLast()){
            stack.removeLast();
        }
        stack.addLast(elem);
    }
}
