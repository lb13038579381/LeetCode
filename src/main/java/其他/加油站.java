package 其他;

import java.util.HashMap;
import java.util.Map;

public class 加油站 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(fun(gas, cost));
    }

    private static int fun(int[] gas, int[] cost) {
        int totalCost = 0;
        int startIndex = 0;
        int tempCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += cost[i] - gas[i];
            tempCost += cost[i] - gas[i];
            if(tempCost > 0) {
                startIndex = i+1;
                tempCost = 0;
            }
        }
        if(totalCost > 0) {
            return -1;
        }
        return startIndex;
    }
}
