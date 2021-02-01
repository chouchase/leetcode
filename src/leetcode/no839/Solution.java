package leetcode.no839;

import datastruct.unionfind.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numSimilarGroups(String[] strs) {
        UnionFind uf = new UnionFind(strs.length);
        for(int i = 0; i < strs.length; i ++){
            for(int j = i + 1; j < strs.length; j ++){
                if(isLike(strs[i],strs[j])){
                    uf.union(i,j);
                }
            }
        }
        return uf.getSetSize();
    }
    private boolean isLike(String str,String str1){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) != str1.charAt(i)){
                list.add(i);
            }
        }
        if(list.size() == 0){
            return true;
        }
        if(list.size() == 2){
            return str.charAt(list.get(0)) == str1.charAt(list.get(1)) && str1.charAt(list.get(0)) == str.charAt(list.get(1));
        }
        return false;
    }
}
