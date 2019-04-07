package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Happy Number
 * <p>
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
public class MediumIsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(4));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else {
            List<Integer> list = new ArrayList<>();
            return isHappy(n, list);
        }
    }

    private static boolean isHappy(int n, List<Integer> list) {
        if (n == 1) return true;
        if (list.contains(n)) {
            return false;
        }
        list.add(n);
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return isHappy(sum, list);
    }
}
