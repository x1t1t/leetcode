package math;

/**
 * Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MediumMyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        int num = 1;
        double res = x;
        while (num < n / 2) {
            res *= res;
            num *= 2;
        }
        return res * myPow(x, n - num);
    }
}
