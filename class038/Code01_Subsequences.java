package class038;

import java.util.HashSet;

/*
https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
描述
给定一个字符串s，长度为n，求s的所有子序列
1.子序列: 指一个字符串删掉部分字符（也可以不删）形成的字符串，可以是不连续的，比如"abcde"的子序列可以有"ace","ad"等等
2.将所有的子序列的结果返回为一个字符串数组
3.字符串里面可能有重复字符，但是返回的子序列不能有重复的子序列，比如"aab"的子序列只有"","a","aa","aab","ab","b"，不能存在2个相同的"ab"
4.返回字符串数组里面的顺序可以不唯一

数据范围:
0<=s.length<=16

要求:时间复杂度为 O(2^n) 
*/
public class Code01_Subsequences {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param s string字符串
     * @return string字符串一维数组
     */
    public String[] generatePermutation(String s) {
        // write code here
        char[] str = s.toCharArray();
        HashSet<String> set = new HashSet<>();
        f1(str, 0, new StringBuffer(), set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }

    public static void f1(char[] str, int i, StringBuffer path, HashSet<String> set) {
        if (i == str.length) {
            set.add(path.toString());
        } else {
            path.append(str[i]);
            f1(str, i + 1, path, set);
            path.deleteCharAt(path.length() - 1);
            f1(str, i + 1, path, set);
        }
    }

    public String[] generatePermutation2(String s) {
        // write code here
        char[] str = s.toCharArray();
        HashSet<String> set = new HashSet<>();
        f2(str, 0, new char[s.length()], 0, set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }

    public static void f2(char[] str, int i, char[] path, int size, HashSet<String> set) {
        if (i == str.length) {
            set.add(String.valueOf(path, 0, size));
        } else {
            path[size] = str[i];
            f2(str, i + 1, path, size + 1, set);
            f2(str, i + 1, path, size, set);
        }
    }

}
