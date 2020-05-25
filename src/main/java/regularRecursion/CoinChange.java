package regularRecursion;

public class CoinChange {

    private int coinsNeeded = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] denom = {1, 5, 10, 20, 50};
        int amount = 26;
        CoinChange obj = new CoinChange();
        obj.coinChange(denom, amount, 0);
        System.out.println("Coins needed:" + obj.coinsNeeded);
    }

    private int coinChange(int[] denom, int amount, int coinsSoFar) {
        if (amount == 0) {
           return coinsSoFar;
        }
        if (amount < 0) {
            return -1;
        }
        int tempRes = -1;
        for (int coin : denom) {
            tempRes = coinChange(denom, amount - coin, coinsSoFar + 1);
            if(tempRes>=0){
                if(tempRes < coinsNeeded){
                    coinsNeeded = tempRes;
                }
            }
        }
        return tempRes;
    }
}
