package class038;

import java.util.*;

// 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的组合
// 答案 不能 包含重复的组合。返回的答案中，组合可以按 任意顺序 排列
// 注意其实要求返回的不是子集，因为子集一定是不包含相同元素的，要返回的其实是不重复的组合
// 比如输入：nums = [1,2,2]
// 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 测试链接 : https://leetcode.cn/problems/subsets-ii/

public class Code02_Combinations {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, res);
        return res;

    }

    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            res.add(cur);
        } else {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            f(nums, j, path, size, res);// 选0个,从j开始处理第二组
            for (; i < j; i++) {
                path[size++] = nums[i];
                f(nums, j, path, size, res);
            }
        }
    }
}
