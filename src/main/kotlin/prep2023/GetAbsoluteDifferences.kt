package prep2023

import kotlin.math.abs

fun main() {
    println(getSumAbsoluteDifferences(intArrayOf(3, 8, 8, 8)).contentToString())
}

fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val memo = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        if (memo.containsKey(nums[i])) {
            result[i] = memo[nums[i]] ?: 0
        }
        var sum = 0
        for (j in nums.indices) {
            sum += abs(nums[i] - nums[j])
        }
        memo[nums[i]] = sum
        result[i] = sum
    }
    return result
}

// (nums[i] - nums[i]) + (nums[i+1] - nums[i]) + (nums[i+2] - nums[i])