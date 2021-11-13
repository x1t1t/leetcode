package array;

import java.util.ArrayList;
import java.util.List;

public class MediumNumberOfArithmeticSlices {

    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 7};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
//        if (nums.length < 3) return 0;
//        int sum = 0;
//        List<Integer> subList = new ArrayList<>();
//        for (int i = 1; i < nums.length; i++) {
//            subList.add(nums[i] - nums[i - 1]);
//        }
//        List<Integer> equalNums = new ArrayList<>();
//        int flag = 1;
//        for (int i = 1; i < subList.size(); i++) {
//            if (subList.get(i).equals(subList.get(i - 1))) {
//                flag++;
//                if (i == subList.size() - 1) {
//                    equalNums.add(flag);
//                }
//            } else {
//                equalNums.add(flag);
//                flag = 1;
//            }
//        }
//        for (Integer equalNum : equalNums) {
//            if (equalNum < 2) {
//                continue;
//            }
//            sum += ((equalNum * (equalNum - 1)) / 2);
//        }
//        return sum;

        if(nums.length<3) return 0;
        int sum = 0, flag=0;
        int step = nums[1] - nums[0];
        for(int i =2; i< nums.length; i++){
            if(nums[i]- nums[i-1] == step) {
                flag++;sum+=flag;
            } else {
                step = nums[i]- nums[i-1];
                flag=0;
            }

        }
        return sum;
    }
}
