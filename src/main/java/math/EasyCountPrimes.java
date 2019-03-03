package math;

/**
 * Count Primes
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class EasyCountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int count = 0;
        if (n > 2) count = 1;
        for (int i = 3; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= Math.sqrt(i) + 1; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
