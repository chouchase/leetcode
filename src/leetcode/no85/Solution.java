package leetcode.no85;

import java.util.ArrayDeque;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        //better
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] height = new int[rows][cols];
        for(int i = 0; i < cols; i ++){
            height[0][i] = matrix[0][i] - '0';
        }
        for(int i = 1; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(matrix[i][j] == '1'){
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[][] left = new int[rows][cols];
        int res = 0;
        for(int i = 0; i < rows; i ++){
            stack.clear();
            stack.push(-1);
            for(int j = 0; j < cols; j ++){
                int val = height[i][j];
                while(stack.peek() != -1 && val <= height[i][stack.peek()]){
                    stack.pop();
                }
                left[i][j] = stack.peek();
                stack.push(j);
            }
        }
        int[][] right = new int[rows][cols];
        for(int i = 0; i < rows; i ++){
            stack.clear();
            stack.push(cols);
            for(int j = cols - 1; j >= 0; j --){
                int val = height[i][j];
                while(stack.peek() != cols && val <= height[i][stack.peek()]){
                    stack.pop();
                }
                right[i][j] = stack.peek();
                stack.push(j);
            }
        }
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                res = Math.max(res,(right[i][j] - left[i][j] - 1) * height[i][j]);
            }
        }
        return res;
       /* int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] left = new int[rows][cols];
        for(int i = 0; i < rows; i ++){
            left[i][0] = matrix[i][0] - '0';
            for(int j = 1; j < cols; j ++){
                if(matrix[i][j] == '1'){
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                int minWidth = Integer.MAX_VALUE;
                int maxArea = 0;
                for(int k = i; k >= 0; k --){
                    minWidth = Math.min(minWidth,left[k][j]);
                    maxArea = Math.max(maxArea,minWidth * (i - k + 1));
                }
                res = Math.max(res,maxArea);

            }
        }
        return res;*/
    }

    public static void main(String[] args) {
        //char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'0','0','1'},{'1','1','1'}};
        new Solution().maximalRectangle(matrix);
    }
}
