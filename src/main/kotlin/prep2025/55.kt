package prep2025

fun main() {

}

fun canJump(nums: IntArray): Boolean {
    var goal = nums.lastIndex
    for (i in nums.lastIndex downTo 0) {
        if (i + nums[i] >= goal) {
            goal = i
        }
    }
    return goal == 0
}
