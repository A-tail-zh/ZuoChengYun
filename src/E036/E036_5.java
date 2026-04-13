package E036;

//111. 二叉树的最小深度
//https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
//给定一个二叉树，找出其最小深度。
//
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//说明：叶子节点是指没有子节点的节点。

import util.TreeNode;

public class E036_5 {
    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return  0;
            if(root.right == null && root.left == null) return 1;
            int ldeep = Integer.MAX_VALUE;
            int rdeep = Integer.MAX_VALUE;
            if(root.left != null){
                ldeep = minDepth(root.left);
            }
            if(root.right != null){
                rdeep = minDepth(root.right);
            }
            return Math.min(ldeep,rdeep) +1;
        }
    }
}
