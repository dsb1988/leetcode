package prep2024

import kotlin.math.min

fun main() {
    println(findMin(intArrayOf(1, 2)))
    println(findMin(intArrayOf(2, 1)))
    println(findMin(intArrayOf(5, 1, 2, 3, 4)))
    println(findMin(intArrayOf(6, 7, 8, 1, 2, 3, 4, 5)))
}

fun findMin(nums: IntArray): Int {
    if (nums.isEmpty()) return Integer.MIN_VALUE
    var result = nums.first()
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        if (nums[left] < nums[right]) {
            result = min(result, nums[left])
            break
        }

        val mid = (left + right) / 2
        result = min(result, nums[mid])
        if (nums[mid] >= nums[left]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return result
}