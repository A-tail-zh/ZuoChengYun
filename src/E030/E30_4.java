package E030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

//381. O(1) 时间插入、删除和获取随机元素 - 允许重复
//https://leetcode.cn/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
//RandomizedCollection 是一种包含数字集合(可能是重复的)的数据结构。它应该支持插入和删除特定元素，以及删除随机元素。
//
//实现 RandomizedCollection 类:
//
//RandomizedCollection()初始化空的 RandomizedCollection 对象。
//bool insert(int val) 将一个 val 项插入到集合中，即使该项已经存在。如果该项不存在，则返回 true ，否则返回 false 。
//bool remove(int val) 如果存在，从集合中移除一个 val 项。如果该项存在，则返回 true ，否则返回 false 。注意，如果 val 在集合中出现多次，我们只删除其中一个。
//int getRandom() 从当前的多个元素集合中返回一个随机元素。每个元素被返回的概率与集合中包含的相同值的数量 线性相关 。
//您必须实现类的函数，使每个函数的 平均 时间复杂度为 O(1) 。
public class E30_4 {
    class RandomizedCollection {
        private HashMap<Integer, HashSet<Integer>> map;
        private ArrayList<Integer> arr ;
        private Random r;

        public RandomizedCollection() {
            map = new HashMap<>();
            arr = new ArrayList<>();
            r = new Random();
        }

        public boolean insert(int val) {
            arr.add(val);
            HashSet<Integer> set = map.getOrDefault(val,new HashSet<Integer>());
            set.add(arr.size() -1);
            map.put(val,set);
            return set.size() == 1;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            HashSet<Integer> valSet = map.get(val);
            int valAnyIndex = valSet.iterator().next();//获取随机元素(获取的是hashSet中的第一个元素，hashSet无序)
            int endValue = arr.get(arr.size() -1);
            if(val == endValue){
                valSet.remove(arr.size() -1);
            }else{
                HashSet<Integer> endValueSet = map.get(endValue);
                endValueSet.add(valAnyIndex);
                arr.set(valAnyIndex,endValue);
                endValueSet.remove(arr.size() -1);
                valSet.remove(valAnyIndex);
            }
            arr.remove(arr.size() -1);
            if(valSet.isEmpty()){
                map.remove(val);
            }
            return true;
        }

        public int getRandom() {
            return arr.get(r.nextInt(arr.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
