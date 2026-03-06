package E030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//LCR 030. O(1) 时间插入、删除和获取随机元素
//https://leetcode.cn/problems/FortPu/description/
//设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构：
//
//        insert(val)：当元素 val 不存在时返回 true ，并向集合中插入该项，否则返回 false 。
//        remove(val)：当元素 val 存在时返回 true ，并从集合中移除该项，否则返回 false 。
//        getRandom：随机返回现有集合中的一项。每个元素应该有 相同的概率 被返回。
public class E030_3 {
    class RandomizedSet {
        private final HashMap<Integer, Integer> map;
        private final ArrayList<Integer> arr;
        private final Random random;  // ✅ 添加为成员变量

        public RandomizedSet() {
            map = new HashMap<>();
            arr = new ArrayList<>();
            random = new Random();  // ✅ 只创建一次
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            arr.add(val);
            map.put(val, arr.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }

            int index = map.get(val);
            int lastIndex = arr.size() - 1;

            // 如果要删除的是最后一个元素
            if (index == lastIndex) {
                arr.remove(lastIndex);
                map.remove(val);  // ✅ 正确：删除的是 val，不是 lastIndex
                return true;
            }

            // 用最后一个元素覆盖要删除的位置
            int lastValue = arr.get(lastIndex);
            arr.set(index, lastValue);  // ✅ 正确：设置 lastValue
            map.put(lastValue, index);  // ✅ 更新最后一个元素的索引

            // 删除最后一个元素
            arr.remove(lastIndex);
            map.remove(val);  // ✅ 正确：删除 val

            return true;
        }

        public int getRandom() {
            return arr.get(random.nextInt(arr.size()));  // ✅ 使用成员变量
        }
    }
}