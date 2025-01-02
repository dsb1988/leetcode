package prep2024

fun main() {
    println(maxProfit(intArrayOf(1, 2)))
}

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    var result = 0
    var minPrice = Int.MAX_VALUE
    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        }
        if (price - minPrice > result) {
            result = price - minPrice
        }
    }
    return result
}