class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int res[][] = new int[n + 1][amount + 1];
        Arrays.fill(res[0], amount + 1);
        for (int i = 0; i <= n; i++) {
            res[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = Math.min(res[i - 1][j], 1 + res[i][j - coins[i - 1]]);
                }
            }
        }
        if (res[n][amount] > amount)
            return -1;
        return res[n][amount];
    }
}