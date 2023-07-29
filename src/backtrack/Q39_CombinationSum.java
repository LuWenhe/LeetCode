package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Q39_CombinationSum {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            track.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i);
            track.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new Q39_CombinationSum().combinationSum(candidates, target);
        System.out.println(lists);
    }

}
