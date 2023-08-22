package greedy;

public class Q134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // 将每个加油站作为起点
        for (int start = 0; start < n; start++) {
            // 当前汽油总量和消耗总量
            int currentGas = 0, currentCost = 0;

            // 从每个起点出发行驶一周
            for (int i = 0; i < n; i++) {
                int j = (start + i) % n;

                currentGas += gas[j];
                currentCost += cost[j];

                if (currentGas < currentCost) {
                    break;
                }
            }

            if (currentGas >= currentCost) {
                return start;
            }
        }

        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0; // 总的汽油量
        int currentGas = 0; // 当前剩余汽油量
        int start = 0; // 起始加油站的索引

        for (int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i]; // 计算总的汽油量和消耗量的差值
            currentGas += gas[i] - cost[i]; // 更新当前剩余汽油量

            // 如果从起点到当前加油站的过程中汽油不足以支持行驶到下一个加油站
            // 那么起点需要从下一个加油站重新开始
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        // 如果总的汽油量小于总的消耗量，无法行驶一周
        if (totalGas < 0) {
            return -1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int res = new Q134_GasStation().canCompleteCircuit2(gas, cost);
        System.out.println(res);
    }

}
