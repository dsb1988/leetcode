package prep2024

fun main() {
    println("Next Permutation")
    val nums = intArrayOf(1, 3, 2)
    nextPermutation(nums)
    println(nums.contentToString())
}

fun nextPermutation(nums: IntArray): Unit {
    if (nums.isEmpty()) return
    if (nums.size == 1) return

    var right = nums.lastIndex
    while (right > 0) {
        if (nums[right] > nums[right - 1]) {
            var swapIndex = right
            for (j in right..nums.lastIndex) {
                if (nums[j] > nums[right - 1] && nums[j] < nums[swapIndex]) {
                    swapIndex = j
                }
            }
            val temp = nums[right - 1]
            nums[right - 1] = nums[swapIndex]
            nums[swapIndex] = temp

            break
        }
        right--
    }

    for (i in 0 until nums.lastIndex - right) {
        for (j in right until nums.size - 1) {
            if (nums[j] > nums[j + 1]) {
                val temp = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp
            }
        }
    }
}
