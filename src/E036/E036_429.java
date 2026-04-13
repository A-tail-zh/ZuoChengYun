package E036;

import util.Node;

import java.util.ArrayList;
import java.util.List;
//429. N 叉树的层序遍历
//https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/
//相关企业
//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
//
//树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
public class E036_429 {


    class Solution {
        private final int maxSize = 10001;
        private final Node[] nodes = new Node[maxSize];
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if(root == null) return ans;
            int l = 0,r = 0;
            nodes[r++] = root;

            while(l < r){
                int size = r - l;
                List<Integer> integersList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node curNode = nodes[l++];
                    integersList.add(curNode.val);
                    while(!curNode.children.isEmpty()){
                        nodes[r++] = curNode.children.get(0);
                        curNode.children.remove(0);
                    }
                }
                ans.add(integersList);
            }



            return ans;
        }
    }

}
