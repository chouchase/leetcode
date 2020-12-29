package leetcode.no205;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return true;
        }
        Map<Character,Character> sToT = new HashMap<>();
        Map<Character,Character> tToS = new HashMap<>();
        for(int i = 0; i < s.length(); i ++){
            if(!sToT.containsKey(s.charAt(i)) && !tToS.containsKey(t.charAt(i))){
                sToT.put(s.charAt(i),t.charAt(i));
                tToS.put(t.charAt(i),s.charAt(i));
            }else if(sToT.containsKey(s.charAt(i)) && tToS.containsKey(t.charAt(i))){
                if(sToT.get(s.charAt(i)) != t.charAt(i) ||  tToS.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

}
