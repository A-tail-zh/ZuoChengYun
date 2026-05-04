package E030;

import java.util.ArrayList;
import java.util.HashMap;

//895. 最大频率栈
//https://leetcode.cn/problems/maximum-frequency-stack/description/
//设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
//
//实现 FreqStack 类:
//
//FreqStack() 构造一个空的堆栈。
//void push(int val) 将一个整数 val 压入栈顶。
//int pop() 删除并返回堆栈中出现频率最高的元素。
//如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素
public class E30_6 {
    class FreqStack {
        int topTime = 0;
        private HashMap<Integer,Integer> countTable;
        private HashMap<Integer, ArrayList<Integer>> valueStack;

        public FreqStack() {
            countTable = new HashMap<>();
            valueStack = new HashMap<>();
        }

        public void push(int val) {
            countTable.put(val,countTable.getOrDefault(val,0)+1);
            int curTopTime = countTable.get(val);
            if(!valueStack.containsKey(curTopTime)){
                valueStack.put(curTopTime,new ArrayList<>());
            }
            ArrayList<Integer> curTimeValues = valueStack.get(curTopTime);
            curTimeValues.add(val);
            topTime = Math.max(topTime,curTopTime);
        }

        public int pop() {
            ArrayList<Integer> topTimeValues = valueStack.get(topTime);
            int ans = topTimeValues.remove(topTimeValues.size() -1);
            if(topTimeValues.isEmpty()){
                valueStack.remove(topTime--);
            }
            int time = countTable.get(ans);
            if(time == 1) {
                countTable.remove(ans);
            }else{
                countTable.put(ans,time -1);
            }
            return ans;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
