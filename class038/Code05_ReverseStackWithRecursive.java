
package class038;

import java.util.*;

public class Code05_ReverseStackWithRecursive {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            int nums = bottomOut(stack);
            reverse(stack);
            stack.push(nums);
        }

    }

    public static int bottomOut(Stack<Integer> stack) {
        int nums = stack.pop();
        if (stack.isEmpty()) {
            return nums;
        } else {
            int last = bottomOut(stack);
            stack.push(nums);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());
        reverse(stack);
        System.out.println(stack.toString());

    }
}
