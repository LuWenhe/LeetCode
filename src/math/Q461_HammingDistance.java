package math;

public class Q461_HammingDistance {

    public int hammingDistance(int x, int y) {
        // 异或运算。假设 x 为 001，y 为 100（即十进制 1、4），则结果为 101。
        int s = x ^ y, ret = 0;

        while (s != 0) {
            // 判断 x 是否为奇数，即判断 x 的最右边是否为 1，写法等价于 x & 1
            // 假设 x 为 101，则条件成立
            if (s % 2 != 0) {
                ret++;
            }

            // x 往右移一位，写法等价于 x >>= 1。假设 x 为 101，则结果为 10（最右边的 1 被舍去）
            s >>= 1;
        }

        return ret;
    }

}
