package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Q46_Permutations {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, track, used);
        return res;
    }

    void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
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
            backTrack(nums, track, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Q46_Permutations().permute(nums);
        System.out.println(permute);
    }

}
