class Solution {
    public boolean checkPrimeFrequency(int[] nums) {

        int[] freq = new int[101];

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: Check whether any frequency is prime
        for (int count : freq) {

            if (isPrime(count)) {
                return true;
            }
        }

        return false;
    }

    // Method to check prime number
    public boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}