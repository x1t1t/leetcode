package math;

/**
 * Power of Three
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 */
public class EasyIsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(4));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        long flag = 3;
        while (flag <= n && flag < Integer.MAX_VALUE) {
            if (flag == n) return true;
            flag = Math.min(Integer.MAX_VALUE, 3 * flag);
        }
        return false;
    }
}
