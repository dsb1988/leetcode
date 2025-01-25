package prep2025

import kotlin.math.min

fun main() {
//    println(coinChange(intArrayOf(1,2,5), 11))
    println(coinChange(intArrayOf(2), 3))
}

fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (rem in 1..amount) {
        for (coin in coins) {
            if (rem - coin >= 0) {
                dp[rem] = min(dp[rem], 1 + dp[rem - coin])
            }
        }
    }
    return if (dp[amount] != amount + 1) dp[amount] else -1
}