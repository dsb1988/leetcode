package prep2024

fun main() {
    val array = intArrayOf(2, 7, 11, 15)
    val target = 9
    println(twoSum(array, target).contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    var left = 0
    while (left < nums.size - 1) {
        val need = target - nums[left]
        var right = left + 1
        while (right < nums.size) {
            if (nums[right] == need) {
                return intArrayOf(left, right)
            }
            right++
        }
        left++
    }
    return intArrayOf()
}