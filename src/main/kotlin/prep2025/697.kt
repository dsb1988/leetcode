package prep2025

import kotlin.math.min

fun main() {
    println(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1)))
}

fun findShortestSubArray(nums: IntArray): Int {
    val degrees = hashMapOf<Int, Int>()
    val firstSeen = hashMapOf<Int, Int>()
    var maxDegree = 0
    var minLength = Int.MAX_VALUE

    nums.forEachIndexed { index, n ->
        if (firstSeen.getOrDefault(n, -1) == -1) {
            firstSeen[n] = index
        }
        val degree = degrees.getOrDefault(n, 0) + 1
        degrees[n] = degree
        if (degree > maxDegree) {
            maxDegree = degree
            minLength = index - firstSeen.getOrDefault(n, 0) + 1
        } else if (degree == maxDegree) {
            minLength = min(minLength, index - firstSeen.getOrDefault(n, 0) + 1)
        }
    }
    return minLength
}