package prep2024

fun main() {
    println(searchSorted(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
}

fun searchSorted(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    if (target > nums.last()) return -1
    if (target < nums.first()) return -1
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val middle = (left + right) / 2
        if (nums[middle] == target) {
            return middle
        } else if (nums[middle] > target) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }
    return -1
}