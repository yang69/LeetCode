package TEMP;

/**
 * Created by Yang on 2017/10/9.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0; //当前所在的加油站
        int start = gas.length; //出发的加油站, gas.length就是0号加油站
        int total = 0; //剩余油量

        do {
            if (total + gas[current] - cost[current] >= 0) { //可以从i号加油站驶向i+1号加油站
                total += (gas[current] - cost[current]);
                current++;
            } else { //汽油不足，尝试在start的前一个加油站出发
                start--;
                total += (gas[start] - cost[start]);
            }
        } while (current != start);

        return total >= 0 ? start % gas.length : -1;
    }
}
