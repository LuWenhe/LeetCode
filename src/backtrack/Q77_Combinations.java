package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Q77_Combinations {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(1, n, k);
        return res;
    }

    private void backTrack(int start, int n, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(i + 1, n, k);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Q77_Combinations().combine(4, 2);
        System.out.println(combine);
    }

}
