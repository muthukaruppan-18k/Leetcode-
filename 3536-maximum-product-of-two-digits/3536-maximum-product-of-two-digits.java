import java.util.Arrays;

class Solution {
    public int maxProduct(int n) {
        // Convert the number to a string to easily access characters
        String str = Integer.toString(n);
        int len = str.length();
        int[] digits = new int[len];
        
        // Fill the array with individual digits
        for (int i = 0; i < len; i++) {
            digits[i] = str.charAt(i) - '0';
        }

        Arrays.sort(digits);
        
        // Multiply the two largest digits (at the end of the array)
        return digits[len - 1] * digits[len - 2];
    }
}
