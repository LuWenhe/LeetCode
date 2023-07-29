package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47_PermutationsII {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used);
        return res;
    }

    public void backTrack(int[] nums, boolean[] used) {
        if (track.size() == used.length) {
            res.add(new LinkedList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }

            track.add(nums[i]);
            used[i] = true;
            backTrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new Q47_PermutationsII().permuteUnique(nums);
        System.out.println(lists);
    }

}
