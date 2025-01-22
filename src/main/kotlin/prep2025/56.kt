package prep2025

import kotlin.math.max

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { i -> i[0] }
    val result = mutableListOf<IntArray>()
    result.add(intervals[0])
    for (i in 1..intervals.lastIndex) {
        val current = intervals[i]
        val lastInterval = result.last()
        val lastEnd = lastInterval[1]
        val nextStart = current[0]
        if (nextStart <= lastEnd) {
            result[result.lastIndex][1] = max(lastEnd, current[1])
        } else {
            result.add(intArrayOf(current[0], current[1]))
        }
    }
    return result.toTypedArray()
}