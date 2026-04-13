package E036;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//958. 二叉树的完全性检验
//https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/
//给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
//在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。

public class E030_8 {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if (root == null) return true;

            // ✅ 用LinkedList替代ArrayList，避免remove(0)的O(n)开销
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            boolean reachedEnd = false; // 标记：是否已遇到null节点

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();

                if (cur == null) {
                    reachedEnd = true; // 遇到null，进入"尾部阶段"
                } else {
                    if (reachedEnd) {
                        // null之后又出现非null节点 → 不是完全二叉树
                        return false;
                    }
                    // 左右子节点都入队（包括null）
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            return true;
        }
    }
}
