package class037;

import java.util.ArrayList;
import java.util.List;
import util.TreeNode;

//113. 路径总和 II
//https://leetcode.cn/problems/path-sum-ii/description/
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//叶子节点 是指没有子节点的节点。
public class E037_3 {

    public static List<List<Integer>> pathSum(TreeNode root, int aim) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            List<Integer> path = new ArrayList<>();
            f(root, aim, 0, path, ans);
        }
        return ans;
    }

    public static void f(TreeNode cur, int aim, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (cur.left == null && cur.right == null) {
            // 叶节点
            if (cur.val + sum == aim) {
                path.add(cur.val);
                copy(path, ans);
                path.remove(path.size() - 1);
            }
        } else {
            // 不是叶节点
            path.add(cur.val);
            if (cur.left != null) {
                f(cur.left, aim, sum + cur.val, path, ans);
            }
            if (cur.right != null) {
                f(cur.right, aim, sum + cur.val, path, ans);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void copy(List<Integer> path, List<List<Integer>> ans) {
        List<Integer> copy = new ArrayList<>();
        for (Integer num : path) {
            copy.add(num);
        }
        ans.add(copy);
    }

}
