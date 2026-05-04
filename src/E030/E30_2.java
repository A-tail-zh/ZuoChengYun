package E030;

import java.util.HashMap;

//面试题 16.25. LRU 缓存
//https://leetcode.cn/problems/lru-cache-lcci/description/
//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
//
//它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
public class E30_2 {
    class LRUCache {

        class DoubleNode{
            public int value;
            public int key;
            public DoubleNode last;
            public DoubleNode next;
            public DoubleNode(int key,int value) {
                this.key = key;
                this.value = value;
            }

        }

        class DoubleList{
            DoubleNode head;
            DoubleNode tail;
            public DoubleList() {
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode newNode) {
                if(newNode == null) return;
                if(head == null) {
                    head = newNode;
                    tail = newNode;
                }else {
                    tail.next = newNode;
                    newNode.last = tail;
                    tail = newNode;
                }
            }

            //移动节点到顶部
            public void moveNodeToTail(DoubleNode node) {
                if(tail == node) return;
                if(head == node) {
                    head = node.next;
                    head.last = null;
                }else {//节点在中间
                    node.last.next = node.next;
                    node.next.last = node.last;
                }
                node.last = tail;
                node.next = null;
                tail.next = node;
                tail = node;
            }

            public DoubleNode removeHead() {
                if(head == null) return null;
                DoubleNode ans = head;
                if(head == tail) {
                    head = null;
                    tail = null;
                }else {
                    head = ans.next;
                    ans.next = null;
                    head.last = null;
                }
                return ans;
            }
        }

        private HashMap<Integer,DoubleNode> keyNodeMap;
        private DoubleList nodelist;
        private final int cap;

        public LRUCache(int capacity) {
            keyNodeMap = new HashMap<>();
            nodelist = new DoubleList();
            cap = capacity;


        }

        public int get(int key) {
            if(keyNodeMap.containsKey(key)) {
                DoubleNode ans = keyNodeMap.get(key);
                nodelist.moveNodeToTail(ans);
                return ans.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(keyNodeMap.containsKey(key)) {
                DoubleNode node = keyNodeMap.get(key);
                node.value = value;
                nodelist.moveNodeToTail(node);
            }else {
                if(keyNodeMap.size() == cap) {
                    //如果容量满了
                    keyNodeMap.remove(nodelist.removeHead().key);
                }
                //如果容量未满
                DoubleNode newNode = new DoubleNode(key,value);
                keyNodeMap.put(key, newNode);
                nodelist.addNode(newNode);
            }
        }
    }
}
