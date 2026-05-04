package E036;

//LCR 048. 二叉树的序列化与反序列化
//https://leetcode.cn/problems/h54YBf/description/
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

import util.TreeNode;

public class E036_6 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";

            StringBuilder builder = new StringBuilder();
            TreeNode[] queue = new TreeNode[10001];
            int l = 0, r = 0;

            // 根节点入队
            queue[r++] = root;
            builder.append(root.val);

            while(l < r){
                TreeNode curNode = queue[l++];

                // 处理左子节点
                if(curNode.left != null){
                    queue[r++] = curNode.left;
                    builder.append(",").append(curNode.left.val);  // ✅ 修正：输出左子节点的值
                } else {
                    builder.append(",#");  // ✅ 修正：添加逗号
                }

                // 处理右子节点
                if(curNode.right != null){
                    queue[r++] = curNode.right;  // ✅ 修正：使用 r++ 而不是 l++
                    builder.append(",").append(curNode.right.val);  // ✅ 修正：输出右子节点的值
                } else {
                    builder.append(",#");  // ✅ 修正：添加逗号
                }
            }

            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.isEmpty()) return null;

            String[] nodes = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

            TreeNode[] queue = new TreeNode[10001];
            int l = 0, r = 0;
            queue[r++] = root;

            int index = 1;  // 从第二个元素开始
            while(l < r){
                TreeNode curNode = queue[l++];

                // 重建左子节点
                if(!nodes[index].equals("#")){
                    curNode.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue[r++] = curNode.left;
                }
                index++;

                // 重建右子节点
                if(!nodes[index].equals("#")){
                    curNode.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue[r++] = curNode.right;
                }
                index++;
            }

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

}
