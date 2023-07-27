package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q40_CombinationSumII {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int start) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new LinkedList<>(track));
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i + 1);
            track.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = new Q40_CombinationSumII().combinationSum2(candidates, 8);
        System.out.println(lists);
    }

}
