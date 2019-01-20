package ArrayAndString;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int c = removeDuplicates(a);
        System.out.println(c);
        System.out.println(Arrays.toString(a));
    }
    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i =1; i<nums.length; i++){
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
