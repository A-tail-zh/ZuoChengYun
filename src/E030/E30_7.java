package E030;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//432. 全 O(1) 的数据结构
//https://leetcode.cn/problems/all-oone-data-structure/description/
//请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
//
//实现 AllOne 类：
//
//AllOne() 初始化数据结构的对象。
//inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
//dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
//getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
//getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
//注意：每个函数都应当满足 O(1) 平均时间复杂度。

public class E30_7 {

    class AllOne {
        // 定义双向链表节点
        class Node {
            int count;
            Set<String> keys;
            Node prev, next;

            Node(int count) {
                this.count = count;
                this.keys = new HashSet<>();
            }

            // 在当前节点后插入新节点
            public Node insertAfter(Node newNode) {
                newNode.prev = this;
                newNode.next = this.next;
                this.next.prev = newNode;
                this.next = newNode;
                return newNode;
            }

            // 移除当前节点
            public void remove() {
                this.prev.next = this.next;
                this.next.prev = this.prev;
            }
        }

        private Map<String, Node> map; // 快速查找字符串对应的节点
        private Node head, tail;       // 哨兵节点

        public AllOne() {
            map = new HashMap<>();
            head = new Node(0);     // 计数最小边界
            tail = new Node(Integer.MAX_VALUE); // 计数最大边界
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                Node cur = map.get(key);
                Node nextNode = cur.next;
                // 如果下一个节点不是目标计数(count+1)，则插入新节点
                if (nextNode.count != cur.count + 1) {
                    nextNode = cur.insertAfter(new Node(cur.count + 1));
                }
                nextNode.keys.add(key);
                map.put(key, nextNode);

                // 从旧节点移除，如果旧节点空了则删除节点
                cur.keys.remove(key);
                if (cur.keys.isEmpty()) cur.remove();
            } else {
                // 新插入，计数为 1
                Node firstNode = head.next;
                if (firstNode.count != 1) {
                    firstNode = head.insertAfter(new Node(1));
                }
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }

        public void dec(String key) {
            Node cur = map.get(key);
            if (cur.count == 1) {
                map.remove(key);
            } else {
                Node prevNode = cur.prev;
                if (prevNode.count != cur.count - 1) {
                    prevNode = cur.prev.insertAfter(new Node(cur.count - 1));
                }
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }

            cur.keys.remove(key);
            if (cur.keys.isEmpty()) cur.remove();
        }

        public String getMaxKey() {
            // tail.prev 指向计数最大的节点
            return tail.prev == head ? "" : tail.prev.keys.iterator().next();
        }

        public String getMinKey() {
            // head.next 指向计数最小的节点
            return head.next == tail ? "" : head.next.keys.iterator().next();
        }
    }
}