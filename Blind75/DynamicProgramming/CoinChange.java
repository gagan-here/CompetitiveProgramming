package Blind75.DynamicProgramming;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * <br>
 * Input: coins = [1,2,5], amount = 11 <br>
 * Output: 3 <br>
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * <p>
 * Example 2:
 * <br>
 * Input: coins = [2], amount = 3 <br>
 * Output: -1 <br>
 *
 * <p>
 * Example 3:
 * <br>
 * Input: coins = [1], amount = 0 <br>
 * Output: 0
 */
public class CoinChange {
    public static int numOfCoins(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // Here, 1 + minCoins[i - coin], represents taking one coin of current coin value and
                    // the minimum number of coins required to make up the remaining amount i - coin.
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }
        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int total = numOfCoins(coins, amount);
        System.out.println("Number of coins needed to make up amount "+ amount + " is: "+total);
    }
}

