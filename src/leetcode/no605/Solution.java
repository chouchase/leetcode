package leetcode.no605;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last = 0;
        int cnt = 0;
        for(int i = 0; i < flowerbed.length && cnt < n; i ++){
            if(flowerbed[i] == 0 && last == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                cnt ++;
                last = 1;
            }else{
                last = flowerbed[i];
            }
        }
        return cnt == n;
    }
}
