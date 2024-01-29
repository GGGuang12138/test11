package leetcode.minimumDifference;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alan
 * @Description
 * @date 2024.01.26 22:04
 */
public class Solution {

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
    

    public static int getMinimumDifference(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left != null){
                res = Math.min(res,Math.abs(curr.val - curr.left.val));
                queue.offer(root.left);
            }
            if(curr.right != null){
                res = Math.min(res,Math.abs(curr.val - curr.right.val));
                queue.offer(root.right);
            }
        }
        return res;
    }
}
