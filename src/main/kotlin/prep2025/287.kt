package prep2025

fun main() {
    println(findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
}

// Floyd's
fun findDuplicate(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var slow = 0
    var fast = 0
    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)
    var slow2 = 0
    do {
        slow = nums[slow]
        slow2 = nums[slow2]
    } while (slow != slow2)

    return slow
}