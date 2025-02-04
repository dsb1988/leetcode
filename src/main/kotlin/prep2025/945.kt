package prep2025

fun main() {
    println(minIncrementForUnique(intArrayOf(1, 2, 2)))
    println(minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)))
}

fun minIncrementForUnique(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size == 1) return 0

    nums.sort()
    var increments = 0
    var left = 0
    var right = 1
    while (right <= nums.lastIndex) {
        if (nums[left] == nums[right]) {
            nums[right] += 1
            increments++
        } else if (nums[left] > nums[right]) {
            increments += nums[left] - nums[right] + 1
            nums[right] = nums[left] + 1
        }
        left++
        right++
    }
    return increments
}