package E036;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//102. 二叉树的层序遍历
//https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

public class E036_1 {

    /**
     * Definition for a binary tree node.
     * public class util.TreeNode {
     * int val;
     * util.TreeNode left;
     * util.TreeNode right;
     * util.TreeNode() {}
     * util.TreeNode(int val) { this.val = val; }
     * util.TreeNode(int val, util.TreeNode left, util.TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    static class Solution {
        private final int maxSize = 2021;
        private final TreeNode[] treeNodes = new TreeNode[maxSize];

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            int l = 0, r = 0;
            treeNodes[r++] = root;
            while (l < r) {
                int size = r - l;
                List<Integer> curList = new ArrayList<>();
                for(int j = 0; j < size ; j++) {
                    TreeNode currentNode = treeNodes[l++];
                    curList.add(currentNode.val);
                    if (currentNode.left != null) {
                        treeNodes[r++] = currentNode.left;
                    }
                    if (currentNode.right != null) {
                        treeNodes[r++] = currentNode.right;
                    }
                }
                ans.add(curList);
            }


            return ans;
        }

    }
}
