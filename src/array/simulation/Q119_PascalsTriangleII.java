package array.simulation;

import java.util.ArrayList;
import java.util.List;

public class Q119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    List<Integer> list1 = lists.get(i - 1);
                    list.add(list1.get(j - 1) + list1.get(j));
                }
            }

            lists.add(list);
        }

        return lists.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> list = new Q119_PascalsTriangleII().getRow(3);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

}
