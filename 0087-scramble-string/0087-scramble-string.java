class Solution {

    // memo[i][j][len]
    // 1  = true
    // 0  = false
    // -1 = not calculated
    int[][][] memo;

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        memo = new int[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(String s1, String s2,
                          int i, int j, int len) {

        // Already calculated
        if (memo[i][j][len] != -1) {
            return memo[i][j][len] == 1;
        }

        // Same substring
        if (s1.substring(i, i + len)
             .equals(s2.substring(j, j + len))) {

            memo[i][j][len] = 1;
            return true;
        }

        // Check character frequency
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int value : count) {
            if (value != 0) {
                memo[i][j][len] = 0;
                return false;
            }
        }

        // Try every possible split
        for (int cut = 1; cut < len; cut++) {

            // Case 1: No swap
            boolean noSwap =
                solve(s1, s2, i, j, cut) &&
                solve(s1, s2, i + cut, j + cut, len - cut);

            if (noSwap) {
                memo[i][j][len] = 1;
                return true;
            }

            // Case 2: Swap
            boolean swap =
                solve(s1, s2, i, j + len - cut, cut) &&
                solve(s1, s2, i + cut, j, len - cut);

            if (swap) {
                memo[i][j][len] = 1;
                return true;
            }
        }

        memo[i][j][len] = 0;
        return false;
    }
}