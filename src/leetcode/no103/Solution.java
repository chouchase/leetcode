package leetcode.no103;


import com.sun.source.tree.Tree;
import leetcode.treenode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int flag = 0;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<TreeNode> temp = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(flag == 0){
                while(!stack.isEmpty()){
                    TreeNode curNode = stack.pop();
                    list.add(curNode.val);
                    if(curNode.left != null){
                        temp.push(curNode.left);
                    }
                    if(curNode.right != null){
                        temp.push(curNode.right);
                    }
                }
            }else{
                while(!stack.isEmpty()){
                    TreeNode curNode = stack.pop();
                    list.add(curNode.val);
                    if(curNode.right != null){
                        temp.push(curNode.right);
                    }
                    if(curNode.left != null){
                        temp.push(curNode.left);
                    }
                }
            }
            flag = 1 - flag;
            res.add(list);
            ArrayDeque<TreeNode> t = stack;
            stack = temp;
            temp = t;
        }
        return res;
    }
}
