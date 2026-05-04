package E036;

import util.TreeNode;

//LCR 175. 计算二叉树的深度
//https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/description/
//某公司架构以二叉树形式记录，请返回该公司的层级数
public class E036_4 {
    class Solution {
        public int calculateDepth(TreeNode root) {
            return root == null? 0:1+Math.max(calculateDepth(root.left),calculateDepth(root.right));
        }
    }
}
