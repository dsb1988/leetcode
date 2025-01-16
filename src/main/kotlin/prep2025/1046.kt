package prep2025

import java.util.*

fun main() {
    println(lastStoneWeight(intArrayOf(3, 7, 8)))
}

fun lastStoneWeight(stones: IntArray): Int {
    val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
    stones.forEach { maxHeap.add(it) }

    while (maxHeap.size >= 2) {
        val y = maxHeap.poll()
        val x = maxHeap.poll()
        if (y != x) {
            maxHeap.add(y - x)
        }
    }

    return if (maxHeap.isEmpty()) {
        0
    } else {
        maxHeap.peek()
    }
}