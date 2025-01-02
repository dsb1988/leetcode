package prep2024

fun main() {
    println("Find First and Last Position of Element in Sorted Array")

    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString())
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentToString())
    println(searchRange(intArrayOf(), 0).contentToString())
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    fun binarySearch(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        var left = 0
        var right = nums.size - 1

        while (left <= right) {
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

    val index = binarySearch(nums, target)
    if (index > -1) {
        var left = index
        while (left > 0 && nums[left - 1] == target) {
            left--
        }
        var right = index
        while (right < nums.size - 1 && nums[right + 1] == target) {
            right++
        }
        return intArrayOf(left, right)
    } else {
        return intArrayOf(-1, -1)
    }
}
