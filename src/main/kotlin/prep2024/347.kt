package prep2024

fun main() {
    println(topKFrequent(intArrayOf(4, 1, -1, 2, -1, 2, 3), 2).contentToString())
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val stats = mutableMapOf<Int, Int>()
    nums.forEach { n ->
        stats[n] = stats.getOrDefault(n, 0) + 1
    }
    return stats.toList().sortedByDescending { it.second }.toMap().keys.take(k).toIntArray()
}