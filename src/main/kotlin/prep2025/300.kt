package prep2025

import kotlin.math.max

fun main() {

}

fun lengthOfLIS(nums: IntArray): Int {
    val memo = IntArray(nums.size) { 1 } // index, LIS
    for (i in nums.lastIndex downTo 0) {
        for (j in i..nums.lastIndex) {
            if (nums[i] < nums[j]) {
                memo[i] = max(memo[i], memo[j] + 1)
            }
        }
    }
    return memo.maxOf { it }
}