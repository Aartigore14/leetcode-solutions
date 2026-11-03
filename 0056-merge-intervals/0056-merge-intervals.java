import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Step 2: Add the first interval
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            // Step 3: Check if intervals overlap
            if (current[1] >= intervals[i][0]) {

                // Merge overlapping intervals
                current[1] = Math.max(current[1], intervals[i][1]);

            } else {

                // No overlap, add current interval
                result.add(current);

                // Move to the next interval
                current = intervals[i];
            }
        }

        // Step 4: Add the last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}