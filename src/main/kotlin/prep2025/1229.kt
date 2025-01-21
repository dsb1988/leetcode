package prep2025

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(
        minAvailableDuration(
            arrayOf(intArrayOf(10, 50), intArrayOf(60, 120), intArrayOf(140, 210)),
            arrayOf(intArrayOf(0, 15), intArrayOf(60, 70)),
            8
        )
    )

    println(
        minAvailableDuration(
            arrayOf(intArrayOf(10, 50), intArrayOf(60, 120), intArrayOf(140, 210)),
            arrayOf(intArrayOf(0, 15), intArrayOf(60, 70)),
            12
        )
    )

    println(
        minAvailableDuration(
            arrayOf(intArrayOf(0, 2)),
            arrayOf(intArrayOf(1, 3)),
            1
        )
    )
}

fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
    slots1.sortWith { o1, o2 -> o1[0] - o2[0] }
    slots2.sortWith { o1, o2 -> o1[0] - o2[0] }

    var i = 0
    var j = 0
    while (i <= slots1.lastIndex && j <= slots2.lastIndex) {
        val start1 = slots1[i][0]
        val end1 = slots1[i][1]
        val start2 = slots2[j][0]
        val end2 = slots2[j][1]

        if (min(end1, end2) - max(start1, start2) >= duration) {
            return listOf(max(start1, start2), max(start1, start2) + duration)
        }

        if (end1 >= end2) {
            j++
        } else {
            i++
        }
    }
    return emptyList()
}