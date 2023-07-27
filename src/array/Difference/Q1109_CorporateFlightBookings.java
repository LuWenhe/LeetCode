package array.Difference;

import java.util.Arrays;

public class Q1109_CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                res[j] += bookings[i][2];
            }
        }

        return Arrays.copyOfRange(res, 1, res.length);
    }

    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);

        for (int[] booking : bookings) {
            int first = booking[0] - 1;
            int last = booking[1] - 1;
            int seats = booking[2];

            difference.increment(first, last, seats);
        }

        return difference.result();
    }

    public static void main(String[] args) {
        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };

        int n =5;
        int[] out = new Q1109_CorporateFlightBookings().corpFlightBookings2(bookings, n);
        System.out.println(Arrays.toString(out));
    }

}
