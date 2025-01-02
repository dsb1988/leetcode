package prep2024

import kotlin.math.max

fun main() {

}

fun trap(height: IntArray): Int {
    var total = 0

    var left = 0
    var right = height.lastIndex
    var leftMax = height[left]
    var rightMax = height[right]
    while (left < right) {
        if (leftMax < rightMax) {
            left++
            leftMax = max(leftMax, height[left])
            total += leftMax - height[left]
        } else {
            right--
            rightMax = max(rightMax, height[right])
            total += rightMax - height[right]
        }
    }
    return total
}