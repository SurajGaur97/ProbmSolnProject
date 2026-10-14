package programsProblem.target75.interval;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.List;

public class MergeIntervals implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        int[][] matrix = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        printElement(merge1(matrix));
    }

    public int[][] merge1(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int[] newInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= newInterval[1])
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            else {
                newInterval = intervals[i];
                res.add(newInterval);
            }
        }

        return res.toArray(int[][]::new);
    }

    public int[][] merge(int[][] intervals) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++)
            res.add(new int[]{intervals[i][0], intervals[i][1]});

        for(int i = 0; i < res.size(); i++) {
            for(int j = i + 1; j < res.size(); j++) {
                if((res.get(i)[0] <= res.get(j)[0] && res.get(j)[0] <= res.get(i)[1]) || (res.get(j)[0] <= res.get(i)[0] && res.get(i)[0] <= res.get(j)[1])) {
                    min = Math.min(res.get(i)[0], res.get(j)[0]);
                    max = Math.max(res.get(i)[1], res.get(j)[1]);
                }
                if(min != Integer.MIN_VALUE && max != Integer.MAX_VALUE) {
                    res.remove(i);
                    res.remove(i);
                    res.add(i, new int[]{min, max});
                    min = Integer.MIN_VALUE; max = Integer.MAX_VALUE;
                    i--;
                    break;
                }
            }
        }

        return res.toArray(int[][]::new);
    }
}
