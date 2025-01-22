package prep2025

import kotlin.math.ceil
import kotlin.math.min

fun main() {
    println(smallestDivisor(intArrayOf(44, 22, 33, 11, 1), 5))
}

fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    fun divSum(nums: IntArray, divisor: Int): Int {
        var result = 0
        nums.forEach { n ->
            result += ceil(n / divisor.toDouble()).toInt()
        }
        return result
    }

    nums.sort()
    var left = 1
    var right = nums.last()
    var minDiv = Int.MAX_VALUE
    while (left <= right) {
        val mid = (left + right) / 2
        val sum = divSum(nums, mid)
        if (sum <= threshold) {
            minDiv = min(minDiv, mid)
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return minDiv
}