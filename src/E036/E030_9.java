package E036;

import util.TreeNode;

//222. 完全二叉树的节点个数
//https://leetcode.cn/problems/count-complete-tree-nodes/
//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
public class E030_9 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNode(root, 1, mostLeft(root, 1));
    }

    public static int countNode(TreeNode root, int level, int h) {
        if (level == h) return 1;
        if (mostLeft(root.right, level + 1) == h) {
            return (1 << (h - level)) + countNode(root.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + countNode(root.left, level + 1, h);
        }
    }

    public static int mostLeft(TreeNode root, int level) {
        while (root != null) {
            level++;
            root = root.left;
        }
        return level - 1;
    }

}
