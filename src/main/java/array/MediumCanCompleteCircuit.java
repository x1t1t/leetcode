package array;

public class MediumCanCompleteCircuit {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length, c = -1;
        int[] km = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                km[i] = gas[i] - cost[i];
            } else {
                km[i] = km[i + 1] + gas[i] - cost[i];
            }
        }
        if (km[0] < 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (km[i] >= max) {
                c = i;
                max = km[i];
            }
        }
        return c;
    }
}
