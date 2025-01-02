package prep2024

import java.lang.Integer.max

fun main() {
    val one = intArrayOf(100, 4, 200, 1, 3, 2)
    println(longestConsecutive(one))
}

fun longestConsecutive(nums: IntArray): Int {
    val stats = nums.toSet()

    var longest = 0
    nums.forEach { num ->
        if (!stats.contains(num - 1)) {
            var length = 1
            while (stats.contains(num + length)) {
                length++
            }
            longest = max(longest, length)
        }
    }
    return longest
}