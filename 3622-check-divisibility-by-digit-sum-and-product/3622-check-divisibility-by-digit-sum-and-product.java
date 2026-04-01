class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, k = n;
        while (k > 0) {
            int temp = k % 10;
            sum += temp;
            product *= temp;
            k /= 10;
        }
        return n % (sum + product) == 0;
    }
}