package others;

public class MediumATM {
    public static void main(String[] args) {
        ATM obj = new ATM();
//        obj.deposit(banknotesCount);
//        int[] param_2 = obj.withdraw(amount);
    }
}

class ATM {

    private long[] count;
    private int[] money;

    public ATM() {
        count = new long[]{0, 0, 0, 0, 0};
        money = new int[]{20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            count[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        // 模拟尝试取出钞票的过程
        for (int i = 4; i >= 0; --i) {
            res[i] = (int) Math.min(count[i], amount / money[i]);
            amount -= res[i] * money[i];
        }
        if (amount > 0) {
            // 无法完成该操作
            return new int[]{-1};
        } else {
            // 可以完成该操作
            for (int i = 0; i < 5; ++i) {
                count[i] -= res[i];
            }
            return res;
        }
    }

}
