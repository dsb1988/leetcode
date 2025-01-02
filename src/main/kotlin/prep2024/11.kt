package prep2024

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

fun maxArea(height: IntArray): Int {
    if (height.size < 2) return 0
    var max = 0
    var i = 0
    var j = height.lastIndex
    while (i != j) {
        val square = (j - i) * min(height[j], height[i])
        max = max(square, max)
        if (height[i] < height[j]) {
            i++
        } else {
            j--
        }
    }
    return max
}