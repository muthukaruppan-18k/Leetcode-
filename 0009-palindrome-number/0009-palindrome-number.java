class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even digits, x should equal reversedHalf (e.g., 1221 -> x=12, reversed=12)
        // For odd digits, we discard the middle digit by reversedHalf/10 (e.g., 121 -> x=1, reversed=12)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
