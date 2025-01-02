package prep2024

fun main() {
    println(searchMatrix(arrayOf(intArrayOf(1)), 1))
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty()) return false

    fun binarySearch(nums: IntArray, target: Int): Boolean {
        if (nums.isEmpty()) return false
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            val middle = (left + right) / 2
            if (nums[middle] == target) {
                return true
            } else if (nums[middle] > target) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }
        return false
    }

    matrix.forEach { nums ->
        if (target >= nums.first() && target <= nums.last()) {
            return binarySearch(nums, target)
        }
    }
    return false
}