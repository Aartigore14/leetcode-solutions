class Solution {
    public boolean hasTrailingZeros(int[] nums) {

        int count = 0;

        for (int num : nums) {

            // Check if the number is even
            if ((num & 1) == 0) {
                count++;
            }

            // Two even numbers are enough
            if (count >= 2) {
                return true;
            }
        }

        return false;
    }
}