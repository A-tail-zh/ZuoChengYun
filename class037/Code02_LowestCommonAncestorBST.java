package class037;

import util.TreeNode;

//235. 二叉搜索树的最近公共祖先
//https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
public class Code02_LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root从上到下
        // 如果先遇到了p，说明p是答案
        // 如果先遇到了q，说明q是答案
        // 如果root在p~q的值之间，不用管p和q谁大谁小，只要root在中间，那么此时的root就是答案
        // 如果root在p~q的值的左侧，那么root往右移动
        // 如果root在p~q的值的右侧，那么root往左移动
        while (root.val != p.val && root.val != q.val) {
            if (root.val > Math.min(p.val, q.val) && (root.val < Math.max(q.val, p.val))) {
                break;
            }
            root = root.val < Math.min(q.val, p.val) ? root.right : root.left;
        }
        return root;
    }
}
