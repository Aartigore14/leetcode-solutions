class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            int sum = 0;

            // Calculate total weight of the word
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                sum += weights[ch - 'a'];
            }

            // Calculate modulo 26
            int remainder = sum % 26;

            // Map to reverse alphabetical order
            char mapped = (char) ('z' - remainder);

            result.append(mapped);
        }

        return result.toString();
    }
}