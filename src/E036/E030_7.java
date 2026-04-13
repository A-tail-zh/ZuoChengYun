package E036;

import util.TreeNode;

import java.util.HashMap;
//105. 从前序与中序遍历序列构造二叉树
//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
public class E030_7 {

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer,Integer> inorderMap = new HashMap<>();
            for(int i = 0; i < inorder.length; i++){
                inorderMap.put(inorder[i],i);
            }
            return buildTreeHelper(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,inorderMap);
        }
        public TreeNode buildTreeHelper(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,
                                        int inEnd,HashMap<Integer,Integer> inorderMap){
            if(preStart > preEnd || inStart > inEnd) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inorderMap.get(root.val);
            int leftNum = inRoot - inStart;
            root.left = buildTreeHelper(preorder,preStart + 1,preStart + leftNum,inorder,inStart,inRoot - 1,inorderMap);
            root.right = buildTreeHelper(preorder,preStart + leftNum + 1,preEnd,inorder,inRoot + 1,inEnd,inorderMap);
            return root;
        }
    }

}
