
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval: intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}