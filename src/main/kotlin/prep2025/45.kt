package prep2025

import kotlin.math.max

fun main() {
    println(jump(intArrayOf(2, 3, 1, 1, 4)))
}

fun jump(nums: IntArray): Int {
    var jumps = 0
    var left = 0
    var right = 0
    while (right < nums.lastIndex) {
        var farthest = 0
        for (i in left..right) {
            farthest = max(farthest, i + nums[i])
        }
        left = right + 1
        right = farthest
        jumps++
    }
    return jumps
}