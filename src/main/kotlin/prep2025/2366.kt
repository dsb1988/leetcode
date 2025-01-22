package prep2025

import kotlin.math.ceil

fun main() {
//    println(minimumReplacement(intArrayOf(5,6,7)))
//    println(minimumReplacement(intArrayOf(3,9,3)))
    println(minimumReplacement(intArrayOf(12, 9, 7, 6, 17, 19, 21)))
}

fun minimumReplacement(nums: IntArray): Long {
    var result = 0L
    var prev = nums.last()
    for (i in nums.lastIndex - 1 downTo 0) {
        if (nums[i] > prev) {
            // break into smaller
            val k = ceil((nums[i] / prev.toDouble())).toInt()
            result += k - 1
            prev = nums[i].floorDiv(k)
        } else {
            prev = nums[i]
        }
    }
    return result
}