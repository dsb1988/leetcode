package prep2024

fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

/**
 * sum = x + y + z
 * -x = y + z
 * -x - y = z
 * z = -1 * (x + y)
 */

fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()
    val result = mutableSetOf<List<Int>>()

    nums.sort() // n long n

    var i = 0
    while (i < nums.size) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            i++
            continue
        } // skip already calculated
        val target = -nums[i]
        var left = i + 1
        var right = nums.lastIndex
        while (left < right) {
            when {
                nums[left] + nums[right] == target -> {
                    result.add(listOf(nums[i], nums[left], nums[right]).sorted())
                    do left++
                    while (left < right && nums[left] == nums[left - 1])
                }

                nums[left] + nums[right] > target -> right--
                nums[left] + nums[right] < target -> left++
            }
        }
        i++
    }

    return result.toList()
}
