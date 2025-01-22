package prep2025

import java.util.*

fun main() {
    println(reorganizeString("aab"))
}

fun reorganizeString(s: String): String {
    if (s.isEmpty()) return s

    val stats = hashMapOf<Char, Int>()
    s.forEach { c -> stats[c] = (stats[c] ?: 0) + 1 }

    val heap = PriorityQueue<Pair<Int, Char>> { p1, p2 -> p2.first - p1.first }
    stats.entries.map { (c, f) -> heap.add(f to c) }
    var prev: Pair<Int, Char>? = null
    var res = ""
    do {
        if (heap.isEmpty() && prev != null) {
            return ""
        }

        val next = heap.poll()
        res += next.second

        if (prev != null) {
            heap.add(prev)
            prev = null
        }

        if (next.first - 1 > 0) {
            prev = next.first - 1 to next.second
        }
    } while (heap.isNotEmpty() || prev != null)

    return res
}