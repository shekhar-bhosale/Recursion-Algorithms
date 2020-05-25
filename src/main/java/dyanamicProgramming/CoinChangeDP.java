package dyanamicProgramming;

import java.util.Arrays;

public class CoinChangeDP {
    public static void main(String[] args) {
        int[] denom = {1, 5, 10};
        int amount = 15;
        CoinChangeDP obj = new CoinChangeDP();
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int coinsNeeded = obj.coinChange(denom, amount, dp);
        System.out.println("Coins needed:" + coinsNeeded);
    }

    private int coinChange(int[] denom, int amount, int dp[]) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        System.out.println("Current dp val for amount:" + amount + " is " + dp[amount]);

        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }

        int valInDp = Integer.MAX_VALUE;
        for (int coin : denom) {
            System.out.println("Current coin:" + coin + "\t amount:" + amount + "\t amount-coin:" + (amount - coin));
            int res = coinChange(denom, amount - coin, dp);
            System.out.println("Current coin:" + coin + "\t Output from recursive call:" + res);
            if (res >= 0) {
                if (res < valInDp) {
                    valInDp = 1 + res;
                }
            }
        }

        dp[amount] = valInDp == Integer.MAX_VALUE ? -1 : valInDp;
        System.out.println("valInDp:" + valInDp + "\t dp array index:"+amount);
        return dp[amount];
    }
}
