package E036;

import util.TreeNode;

//662. 二叉树最大宽度
//https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
//
//树的 最大宽度 是所有层中最大的 宽度 。
//
//每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
//
//题目数据保证答案将会在  32 位 带符号整数范围内。
public class E036_3 {
    class Solution {
        public static int maxSize = 3001;
        public static TreeNode[] nq = new TreeNode[maxSize];
        public static int[] iq = new int[maxSize];
        static int l ,r;
        public int widthOfBinaryTree(TreeNode root) {
            int maxWidth = 0;
            if(root == null) return maxWidth;
            l = r = 0;
            nq[r] = root;
            iq[r++] = 1;
            while(l < r){
                int size = r -l;
                maxWidth = Math.max(iq[r -1] - iq[l] + 1,maxWidth);
                for(int i = 0;i < size;i++){
                    TreeNode node = nq[l];
                    int id = iq[l++];
                    if(node.left != null){
                        nq[r] = node.left;
                        iq[r++] = id*2;
                    }
                    if(node.right != null){
                        nq[r] = node.right;
                        iq[r++] = id*2+1;
                    }
                }
            }

            return maxWidth;
        }
    }
}
