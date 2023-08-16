package greedy;

import java.util.Arrays;

/**
 * 有n个人，每条船最多只能坐两个人、最大载重量是max，求最少需要几条船
 */
public class CrossTheRiver {

    public int cross(int[] people, int maxWeight) {
        Arrays.sort(people);

        int n = people.length, count = 0;
        int i = 0, j = n - 1;

        while (i <= j) {
            if (people[i] + people[j] < maxWeight) {
                i++;
            }

            j--;
            ++count;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] people = {1, 2, 3, 10, 3};
        int manWeight = 10;
        int cross = new CrossTheRiver().cross(people, manWeight);
        System.out.println(cross);
    }

}
