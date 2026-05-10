class Solution {
    public int integerReplacement(int n) {
        // Use long to prevent overflow when n + 1 occurs at Integer.MAX_VALUE
        long num = n;
        int operations = 0;
        
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                // Special case for 3: 3 -> 2 -> 1 is better than 3 -> 4 -> 2 -> 1
                if (num == 3 || (num & 2) == 0) {
                    num--;
                } else {
                    num++;
                }
            }
            operations++;
        }
        return operations;
    }
}
