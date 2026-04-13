package E036;

import util.TreeNode;
import java.util.ArrayList;
import java.util.List;

// 103. 二叉树的锯齿形层序遍历
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
// 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
// （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

public class E036_2 {

    class Solution {

        private final int maxSize = 2021;              // 数组大小，略大于最大节点数2000
        private final TreeNode[] treeNodes = new TreeNode[maxSize];  // 用数组模拟队列
        boolean reversal = false;                       // 控制当前层的遍历方向

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) return ans;               // 空树返回空列表

            int l = 0, r = 0;                            // l: 队首指针，r: 队尾指针（指向下一个空位）
            treeNodes[r++] = root;                        // 根节点入队

            while (l < r) {                               // 队列不为空时循环
                List<Integer> integerList = new ArrayList<>();
                int size = r - l;                          // 当前层的节点数量

                // 第一步：根据当前方向，从数组中取出当前层的节点值
                // 如果 reversal = false: 从左到右取 (i 从 l 递增到 r-1)
                // 如果 reversal = true:  从右到左取 (i 从 r-1 递减到 l)
                for (int i = reversal ? r - 1 : l, j = reversal ? -1 : 1, k = 0;
                     k < size;
                     k++, i += j) {
                    TreeNode curNode = treeNodes[i];
                    integerList.add(curNode.val);
                }

                // 第二步：将当前层的所有节点按顺序出队，并将它们的子节点入队
                // 注意：无论当前层是什么方向，入队顺序都保持一致（这里先右后左）
                for (int i = 0; i < size; i++) {
                    TreeNode cur = treeNodes[l++];        // 取出当前节点，同时l后移

                    if (cur.left != null) {
                        treeNodes[r++] = cur.left;        // 左子节点入队
                    }

                    if (cur.right != null) {
                        treeNodes[r++] = cur.right;       // 右子节点入队
                    }

                }

                ans.add(integerList);                      // 将当前层的结果加入答案
                reversal = !reversal;                       // 反转方向，准备下一层
            }

            return ans;
        }
    }
}