package math;

/**
 * Factorial Trailing Zeroes
 * <p>
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class MediumtTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    public static int trailingZeroes(int n) {
        int count = 0, t = 5;
        while (n > 0) {
            count += (n / t);
            n /= 5;
        }
        return count;
    }
}
