package prep2023

fun main() {
    val candles = arrayOf(3, 2, 1, 3)
    println(birthdayCakeCandles(candles))
}

fun birthdayCakeCandles(candles: Array<Int>): Int {
    // Write your code here
    val max = candles.maxOf { it }
    return candles.count { it == max }
}