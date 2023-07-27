package backtrack;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public void hello(int[] nums, int index) {
        if (nums[index] < 0) {
            return;
        }

        hello(nums, ++index);
        System.out.println("hello");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -1, 5};
        new Test().hello(nums, 0);
    }

}
