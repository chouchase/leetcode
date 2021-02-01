package leetcode.no1128;


class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        for(int[] domino : dominoes){
            if(domino[0] > domino[1]){
                int t = domino[0];
                domino[0] = domino[1];
                domino[1] = t;
            }
        }
        int res = 0;
        for(int i = 0; i < dominoes.length; i ++){
            for(int j = i + 1; j < dominoes.length; j ++){
                if(dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]){
                    res ++;
                }
            }
        }
        return res;
    }
}
