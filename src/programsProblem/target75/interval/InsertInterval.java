package programsProblem.target75.interval;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[][] matrix = new int[][]{{1,3},{6,9}};
        int[] newInterval = new int[]{2,5};

        printElement(insert(matrix, newInterval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= newInterval[0] && newInterval[0] <= intervals[i][1])
                min = intervals[i][0];

            if(intervals[i][0] <= newInterval[1] && newInterval[1] <= intervals[i][1])
                max = intervals[i][1];
        }
        if(min == Integer.MIN_VALUE) min = newInterval[0];
        if(max == Integer.MAX_VALUE) max = newInterval[1];

        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] < min && intervals[i][1] < min) {
                List<Integer> newIntv = new ArrayList<>();
                newIntv.add(intervals[i][0]);
                newIntv.add(intervals[i][1]);
                res.add(newIntv);
            }
        }

        res.add(List.of(min, max));

        for(int i = 0; i < intervals.length; i++) {
            if(max > intervals[i][0] && max > intervals[i][1]) {
                List<Integer> newIntv = new ArrayList<>();
                newIntv.add(intervals[i][0]);
                newIntv.add(intervals[i][1]);
                res.add(newIntv);
            }
        }

        return res.stream().map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
