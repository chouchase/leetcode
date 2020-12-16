package leetcode.wordpatterm290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> charToStr = new HashMap<>();
        Map<String,Character> strToChar = new HashMap<>();
        String[] str = s.split(" ");
        if(str.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i ++){
            char c = pattern.charAt(i);
            if(!charToStr.containsKey(c) && !strToChar.containsKey(str[i])){
                charToStr.put(c,str[i]);
                strToChar.put(str[i],c);
            }else if(!strToChar.containsKey(str[i]) || !charToStr.containsKey(c)){
                return false;
            }else if(strToChar.get(str[i]) != c || !charToStr.get(c).equals(str[i])){
                return false;
            }
        }
        return true;
    }
}
