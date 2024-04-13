package prep2023

fun main() {
    println("Hello Stocks!")
    val prices = intArrayOf(7,1,5,3,6,4)
    val prices2 = intArrayOf(1,2,3,4,5)
    val prices3 = intArrayOf(7,6,4,3,1)
    println("Test 1: ${maxProfit(prices) == 7}")
    println("Test 2: ${maxProfit(prices2) == 4}")
    println("Test 3: ${maxProfit(prices3) == 0}")
}

fun maxProfit(prices: IntArray): Int {
    var result = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i-1]) {
            result += prices[i] - prices[i-1]
        }
    }
    return result
}