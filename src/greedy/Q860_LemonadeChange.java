package greedy;

public class Q860_LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {    // 如果是5元
                five++;
            } else if (bill == 10) {    // 如果是10元
                five--;
                ten++;
            } else {        // 如果超过10元
                if (ten > 0) {      // 如果有10元零钱
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }

            if (five < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        boolean res = new Q860_LemonadeChange().lemonadeChange(bills);
        System.out.println(res);
    }

}
