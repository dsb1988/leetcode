package prep2025

import kotlin.math.min

fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    val sorted = arr.sorted()
    val result = mutableListOf<List<Int>>()
    var minAbs = Int.MAX_VALUE
    for (i in 0 until sorted.lastIndex) {
        minAbs = min(minAbs, sorted[i + 1] - sorted[i])
    }
    for (i in 0 until sorted.lastIndex) {
        if (sorted[i + 1] - sorted[i] == minAbs) {
            result.add(listOf(sorted[i], sorted[i + 1]))
        }
    }
    return result
}