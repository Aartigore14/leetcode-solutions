class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine whether the result should be negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative
        // because -2147483648 cannot be represented as positive int
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        while (a >= b) {

            long value = b;
            long multiple = 1;

            // Find the largest doubled divisor
            while ((value << 1) <= a) {
                value <<= 1;
                multiple <<= 1;
            }

            // Subtract it from dividend
            a -= value;

            // Add corresponding multiple to quotient
            quotient += multiple;
        }

        // Apply sign
        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}