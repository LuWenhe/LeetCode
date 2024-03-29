package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class Q46_Permutations {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used);
        return res;
    }

    void backTrack(int[] nums, boolean[] used) {
        // 如果满足条件, 则添加路径
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backTrack(nums, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permute = new Q46_Permutations().permute(nums);
        System.out.println(permute);
    }

}
