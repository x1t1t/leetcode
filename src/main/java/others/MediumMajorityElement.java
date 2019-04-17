package others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MediumMajorityElement {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        /**ideaI
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;*/

        /**ideaII
        Arrays.sort(nums);
        return nums[nums.length/2];*/

        /**ideaIII*/
        int count = 1, flag = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                flag = nums[i];
            } else if (nums[i] == flag) {
                count++;
            } else {
                count--;
            }
        }
        return flag;
    }
}
