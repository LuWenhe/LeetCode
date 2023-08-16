package greedy;

public class Q134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        return 1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int res = new Q134_GasStation().canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

}
