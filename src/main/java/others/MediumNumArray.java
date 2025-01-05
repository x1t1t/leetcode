package others;

public class MediumNumArray {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }


}

class NumArray {

    /**暴力*/
//    int[] numArray;

    /**线段树*/
//    private int[] segmentTree;
//    private int n;

    /**
     * 树状数组
     */
    int[] ci;
    int[] originNums;

    public NumArray(int[] nums) {
//        numArray = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            numArray[i] = nums[i];
//        }

//        n = nums.length;
//        segmentTree = new int[nums.length * 4];
//        build(0, 0, n - 1, nums);
        ci = new int[nums.length + 1];
        originNums = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int i, int num) {
        while (i < ci.length) {
            ci[i] += num;
            i += lowBit(i);
        }
    }

    private int lowBit(int x) {
        return x & -x;
    }

    public void update(int index, int val) {
//        numArray[index] = val;

//        change(index, val, 0, 0, n - 1);
        add(index + 1, val - originNums[index]);
        originNums[index] = val;
    }

    public int sumRange(int left, int right) {
//        int sum = 0;
//        for (int i = left; i <= right; i++) {
//            sum += numArray[i];
//        }
//        return sum;
//        return range(left, right, 0, 0, n - 1);

        return prefixSum(right + 1) - prefixSum(left);
    }

    private int prefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += ci[index];
            index -= lowBit(index);
        }
        return sum;
    }

//    private void build(int node, int s, int e, int[] nums) {
//        if (s == e) {
//            segmentTree[node] = nums[s];
//            return;
//        }
//        int m = s + (e - s) / 2;
//        build(node * 2 + 1, s, m, nums);
//        build(node * 2 + 2, m + 1, e, nums);
//        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
//    }

//    private void change(int index, int val, int node, int s, int e) {
//        if (s == e) {
//            segmentTree[node] = val;
//            return;
//        }
//        int m = s + (e - s) / 2;
//        if (index <= m) {
//            change(index, val, node * 2 + 1, s, m);
//        } else {
//            change(index, val, node * 2 + 2, m + 1, e);
//        }
//        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
//    }

//    private int range(int left, int right, int node, int s, int e) {
//        if (left == s && right == e) {
//            return segmentTree[node];
//        }
//        int m = s + (e - s) / 2;
//        if (right <= m) {
//            return range(left, right, node * 2 + 1, s, m);
//        } else if (left > m) {
//            return range(left, right, node * 2 + 2, m + 1, e);
//        } else {
//            return range(left, m, node * 2 + 1, s, m) + range(m + 1, right, node * 2 + 2, m + 1, e);
//        }
//    }

}
