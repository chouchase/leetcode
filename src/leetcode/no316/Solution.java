package leetcode.no316;

import java.util.ArrayDeque;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() <= 1){
            return s;
        }
        int[] pos = new int[26];
        boolean[] isAdd = new boolean[26];
        for(int i = 0; i < s.length(); i ++){
            pos[s.charAt(i) - 'a'] = i;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i ++){
            if(isAdd[s.charAt(i) - 'a']) {
                if(i == pos[s.charAt(i) - 'a']){
                    pos[s.charAt(i) - 'a'] = -1;
                }
                continue;
            }
            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && pos[stack.peek() - 'a'] != -1){
                isAdd[stack.pop() - 'a'] = false;
            }
            stack.push(s.charAt(i));
            isAdd[s.charAt(i) - 'a'] = true;
            if(i == pos[s.charAt(i) - 'a']){
                pos[s.charAt(i) - 'a'] = -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
    }
}
