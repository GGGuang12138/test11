package com.lt;

import java.util.LinkedList;

/**
 * @author: Alan
 * @since: 2023/3/27 23:29
 */
public class TreeNodeCodec {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        serialize(treeNode);
    }

    private static String str;

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> dq = new LinkedList<TreeNode>();
        dq.add(root);
        int size = dq.size();
        boolean lowest = true;
        while (dq.size() > 0) {
            // 当前层个数
            size = dq.size();
            // 默认为最底层，存在子树则改为false;
            lowest = true;
            while (size-- > 0) {
                TreeNode node = (dq).pollFirst();
                sb.append(node == null ? "&" : node.val).append(",");
                if (node == null) {
                    dq.add(null);
                    dq.add(null);
                } else {
                    // 存在子节点，则确定不是最后一层
                    if (lowest && (node.left != null || node.right != null)) {
                        lowest = false;
                    }
                    dq.add(node.left);
                    dq.add(node.right);
                }
                if (lowest) {
                    break;
                }
            }
        }
        str = sb.toString();
        return str;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
