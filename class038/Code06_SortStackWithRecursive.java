package class038;

import java.util.*;;
// 用递归函数排序栈
// 栈只提供push、pop、isEmpty三个方法
// 请完成无序栈的排序，要求排完序之后，从栈顶到栈底从小到大
// 只能使用栈提供的push、pop、isEmpty三个方法、以及递归函数
// 除此之外不能使用任何的容器，数组也不行
// 就是排序过程中只能用：
// 1) 栈提供的push、pop、isEmpty三个方法
// 2) 递归函数，并且返回值最多为单个整数

public class Code06_SortStackWithRecursive {

    public static void sort(Stack<Integer> stack){
        int deep = deep(stack);
        while(deep > 0){
            int max = maxNum(stack, deep);
            int times = times(stack, deep, max);
            down(stack, deep, max, times);
            deep -= times;
        }

    }

    public static int deep(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return 0;
        }

        int cur = stack.pop();
        int restDeep = deep(stack) + 1;
        stack.push(cur);
        return restDeep;
    }

    public static int maxNum(Stack<Integer> stack,int deep) {

        if(deep == 0){
            return Integer.MIN_VALUE;
        }
        int cur = stack.pop();
        int restMax = maxNum(stack,  deep-1);
        stack.push(cur);
        return Math.max(restMax, cur); 
    }

    public static int times(Stack<Integer> stack, int deep, int max) {
        if (deep == 0) {
            return 0;
        }
        int cur = stack.pop();
        int restTimes = times(stack, deep - 1, max);
        restTimes += cur == max ? 1 : 0;
        stack.push(cur);
        return restTimes;
    }

    public static void down(Stack<Integer> stack,int deep ,int max,int times){
        if(deep == 0){
            for(int i =0 ;i < times;i++){
                stack.push(max);
            }
        }else{
            int num = stack.pop();
            down(stack,  deep - 1, max, times);
            if(num != max){
                stack.push(num);
            }
        }
    }

    // 为了测试
    // 生成随机栈
    public static Stack<Integer> randomStack(int n, int v) {
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            ans.add((int) (Math.random() * v));
        }
        return ans;
    }

    // 为了测试
    // 检测栈是不是从顶到底依次有序
    public static boolean isSorted(Stack<Integer> stack) {
        int step = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (step > stack.peek()) {
                return false;
            }
            step = stack.pop();
        }
        return true;
    }

    // 为了测试
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.add(1);
        test.add(5);
        test.add(4);
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(2);
        sort(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

        // 随机测试
        int N = 20;
        int V = 20;
        int testTimes = 20000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N);
            Stack<Integer> stack = randomStack(n, V);
            sort(stack);
            if (!isSorted(stack)) {
                System.out.println("出错了!");
                break;
            }
        }
        System.out.println("测试结束");
    }

}
