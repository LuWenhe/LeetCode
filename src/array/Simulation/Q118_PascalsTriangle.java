package array.Simulation;

import java.util.ArrayList;
import java.util.List;

public class Q118_PascalsTriangle {

    /**
     *   1 2 3 4 5
     * 1 1
     * 2 1 1
     * 3 1 2 1
     * 4 1 3 3 1
     * 5 1 4 6 4 1
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> list1 = lists.get(i - 1);
                    list.add(list1.get(j-1) + list1.get(j));
                }
            }

            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Q118_PascalsTriangle().generate(4);

        for (List<Integer> list : lists) {
            for (Integer l : list) {
                System.out.print(l + " ");
            }

            System.out.println();
        }
    }

}
