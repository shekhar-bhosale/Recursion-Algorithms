package regularRecursion;

public class CoinChangeApproach2 {
    private int coinsNeeded = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] denom = {1, 5, 10, 20, 50};
        int amount = 26;
        CoinChangeApproach2 obj = new CoinChangeApproach2();
        obj.coinChange(denom, amount, 0);
        System.out.println("Coins needed:" + obj.coinsNeeded);
    }

    private void coinChange(int[] denom, int amount, int coinsSoFar) {
        if (amount == 0) {
            coinsNeeded = Math.min(coinsSoFar, coinsNeeded);
            return;
        }
        if (amount < 0) {
            return;
        }
        for (int coin : denom) {
            coinChange(denom, amount - coin, coinsSoFar + 1);
        }
    }
}
