package array;

import java.util.*;

public class Q34_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        int[] indexArray = new int[]{-1, -1};
        boolean isFlag = false;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> arrayList = new ArrayList<>();

            if (nums[i] == target) {
                List<Integer> indexArrayList = hashMap.get(nums[i]);

                isFlag = true;

                if (indexArrayList != null) {
                    indexArrayList.add(i);
                    hashMap.put(nums[i], indexArrayList);
                    continue;
                }
            }

            arrayList.add(i);
            hashMap.put(nums[i], arrayList);
        }

        if (!isFlag) {
            return indexArray;
        } else {
            List<Integer> list = hashMap.get(target);
            indexArray[0] = list.get(0);
            indexArray[1] = list.get(list.size() - 1);
        }

        return indexArray;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 7;
        int[] range = new Q34_FindFirstAndLastPositionOfElementInSortedArray()
                .searchRange(nums, target);
        System.out.println(Arrays.toString(range));
    }

}
