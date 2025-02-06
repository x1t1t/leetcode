package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MediumPermuteUnique {

    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        permuteList(nums, res, output, 0);
        return res;
    }

    public void permuteList(int[] nums, List<List<Integer>> res, List<Integer> output, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = index; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            output.add(nums[i]);
            permuteList(nums, res, output, index + 1);
            vis[i] = false;
            output.remove(index);
        }
    }

}
