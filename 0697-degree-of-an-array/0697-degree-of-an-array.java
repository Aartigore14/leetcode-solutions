
import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        // Step 1: Calculate frequency, first and last index
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            last.put(num, i);

            degree = Math.max(degree, freq.get(num));
        }

        // Step 2: Find minimum subarray length
        int minLength = nums.length;

        for (int num : freq.keySet()) {

            if (freq.get(num) == degree) {

                int length = last.get(num) - first.get(num) + 1;

                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}
