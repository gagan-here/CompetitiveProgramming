package Blind75.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] <br>
 * Output: [[1,6],[8,10],[15,18]] <br>
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * <p>
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]] <br>
 * Output: [[1,5]] <br>
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals in ascending order on the basis of first element of each subarray
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // Intervals donot overlap. So add the interval to list
                newInterval = interval;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);
        System.out.println(Arrays.deepToString(mergedIntervals));
    }
}
