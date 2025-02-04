package prep2025

import kotlin.math.max

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var prefixSum = 0
    for (num in nums) {
        if (prefixSum < 0) {
            prefixSum = 0
        }
        prefixSum += num
        maxSum = max(maxSum, prefixSum)
    }
    return maxSum
}