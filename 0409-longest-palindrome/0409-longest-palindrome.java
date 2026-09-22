class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        // Count frequency of every character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        // Use pairs
        for (int count : freq) {
            length += (count / 2) * 2;

            // We can put one odd character in the center
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length++;
        }

        return length;
    }
}