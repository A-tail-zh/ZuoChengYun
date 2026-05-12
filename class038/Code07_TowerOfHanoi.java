package class038;

// 打印n层汉诺塔问题的最优移动轨迹
public class Code07_TowerOfHanoi {
    public static void hanoi(int n) {
        if (n > 0) {
            f(n, "左", "右", "中");
        }
    }

    public static void f(int n, String form, String to, String other) {
        if (n == 1) {
            System.out.println("移动圆盘 1 从" + form + "到" + to);
        } else {
            f(n - 1, form, other, to);
            System.out.println("移动圆盘 " + n + " 从" + form + "到" + to);
            f(n - 1, other, to, form);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
