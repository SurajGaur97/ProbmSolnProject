package programsProblem.practice.array;

import programsProblem.practice.common.DriverClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxProfit implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
//        List<Integer> lengths = new ArrayList<>(Arrays.asList(30, 59, 110));
        List<Integer> lengths = new ArrayList<>(Arrays.asList(26, 103, 59));
        int costPerCut = 1;
        int salePrice = 10;

        System.out.println(maxProfit(costPerCut, salePrice, lengths));
    }

    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        int maxRodLength = Collections.max(lengths);
        int maxProfit = 0;

        for (int saleLength = 1; saleLength <= maxRodLength; saleLength++) {
            int totalUniformRods = 0;
            int totalCuts = 0;

            for (int length : lengths) {
                int cutsNeeded = 0;
                if (length % saleLength != 0) {
                    cutsNeeded = length / saleLength;
                    totalCuts += cutsNeeded;
                }
                int profit = (length % saleLength) * saleLength * salePrice - cutsNeeded * costPerCut;
                if (profit > 0) {
                    totalUniformRods += length / saleLength;
                }
            }

            int totalProfit = totalUniformRods * saleLength * salePrice - totalCuts * costPerCut;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
            }
        }

        return maxProfit;
    }
}
