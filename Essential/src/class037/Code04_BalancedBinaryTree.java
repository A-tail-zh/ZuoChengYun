package class037;

import util.TreeNode;
//110. 平衡二叉树
//https://leetcode.cn/problems/balanced-binary-tree/description/
//给定一个二叉树，判断它是否是 平衡二叉树  

public class E037_4 {

    static boolean balance;

    public boolean isBalanced(TreeNode root) {
        balance = true;
        // balance是全局变量，所有调用过程共享
        // 所以每次判断开始时，设置为true
        height(root);
        return balance;
    }

    // 一旦发现不平衡，返回什么高度已经不重要了
    public static int height(TreeNode cur) {
        if (!balance || cur == null) {
            return 0;
        }
        int lh = height(cur.left);
        int rh = height(cur.right);
        if (Math.abs(lh - rh) > 1) {
            balance = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
