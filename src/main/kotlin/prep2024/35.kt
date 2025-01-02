package prep2024

import kotlin.math.max

fun main() {
    println("Search Insert Position")
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
    println(searchInsert(intArrayOf(1, 3), 2))
    println(searchInsert(intArrayOf(1, 3), 0))
    println(searchInsert(intArrayOf(3, 5, 7, 9, 10), 8))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var lastLeft = -1

    fun binarySearch(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            lastLeft = left

            val midpoint = (left + right) / 2
            if (nums[midpoint] == target) return midpoint

            if (target < nums[midpoint]) {
                right = midpoint - 1
            } else {
                left = midpoint + 1
            }
        }

        return -1
    }

    val targetIndex = binarySearch(nums, target)
    return if (targetIndex > -1) {
        targetIndex
    } else {
        if (target > nums[lastLeft]) {
            return lastLeft + 1
        } else {
            return max(lastLeft, lastLeft - 1)
        }
    }
}