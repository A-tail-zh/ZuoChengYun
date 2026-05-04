package class037;

import util.TreeNode;

// 98. 验证二叉搜索树
// https://leetcode.cn/problems/validate-binary-search-tree/description/
// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
// 有效 二叉搜索树定义如下：
// 节点的左子树只包含 严格小于 当前节点的数。
// 节点的右子树只包含 严格大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
public class E037_5 {

    public static int MAXN = 10001;
    public static TreeNode[] stack = new TreeNode[MAXN];
    public static int r;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        r = 0;
        while (r > 0 || root != null) {
            if (root != null) {
                stack[r++] = root;
                root = root.left;
            } else {
                root = stack[--r];
                if (pre != null && pre.val >= root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    public static long min, max;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            return true;
        }
        boolean lok = isValidBST2(root.left);
        long lmin = min;
        long lmax = max;
        boolean rok = isValidBST2(root.right);
        long rmin = min;
        long rmax = max;
        max = Math.max(root.val, Math.max(lmax, rmax));
        min = Math.min(root.val, Math.min(lmin, rmin));
        return lok && rok && lmax < root.val && root.val < rmin;
    }
}
