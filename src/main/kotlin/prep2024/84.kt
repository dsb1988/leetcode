package prep2024

import kotlin.math.max

fun main() {
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
}

fun largestRectangleArea(heights: IntArray): Int {
    var maxArea = 0
    val stack = mutableListOf<Pair<Int, Int>>()

    heights.forEachIndexed { i, h ->
        var start = i
        while (stack.isNotEmpty() && stack.last().second > h) {
            val last = stack.removeLast()
            maxArea = max(maxArea, last.second * (i - last.first))
            start = last.first
        }
        stack.add(Pair(start, h))
    }
    stack.forEach { (i, h) ->
        maxArea = max(maxArea, h * (heights.size - i))
    }
    return maxArea
}