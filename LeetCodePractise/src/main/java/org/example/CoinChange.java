package org.example;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 20, 50, 100};
        int sum = 500;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[sum]);
    }
}
