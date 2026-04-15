class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow: -2^31 / -1 = 2^31 (which exceeds 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long to prevent overflow during Math.abs()
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Exponentially subtract the divisor
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;
            
            // Double the divisor and the multiple as much as possible
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            absDividend -= tempDivisor;
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }
}
