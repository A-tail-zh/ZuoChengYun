package class037;

import util.TreeNode;

//236. 二叉树的最近公共祖先
//https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
public class Code01_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 寻找左树
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        // 寻找右树
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        // 情况一：左树和右树都找到，说明p和q在两侧返回root
        if (l != null && r != null)
            return root;
        // 情况二：左树和右树都没找到，说明P和q都不在这个子树里，返回空
        if (l == null && r == null)
            return null;
        // 情况三：左树找到或者右树找到，返回找到的
        return l != null ? l : r;
    }
}
