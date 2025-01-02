package prep2024

import kotlin.math.min

fun main() {
    println(minEatingSpeed(intArrayOf(2, 2), 4))
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    if (piles.size > h) return Integer.MIN_VALUE
    if (piles.size == h) {
        return piles.maxOf { it }
    }

    var left = 1
    var right = piles.maxOf { it }
    var result = right

    while (left <= right) {
        val k = (left + right - 1) / right
        var hours = 0L
        for (pile in piles) {
            hours += (pile + k - 1) / k
        }
        if (hours <= h) {
            result = min(result, k)
            right = k - 1
        } else {
            left = k + 1
        }
    }

    return result
}