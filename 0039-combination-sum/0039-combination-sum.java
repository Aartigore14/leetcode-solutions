
import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Valid combination found
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each candidate
        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] <= target) {

                // Choose
                current.add(candidates[i]);

                // Explore
                backtrack(candidates, target - candidates[i],
                          i, current, result);

                // Backtrack (remove last element)
                current.remove(current.size() - 1);
            }
        }
    }
}
