class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry needed, we're done
            }
            digits[i] = 0; // Carry the 1 by setting current to 0
        }

        // If the loop finishes, it means we had a carry all the way (e.g., 999 -> 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
