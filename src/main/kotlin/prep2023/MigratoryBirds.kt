package prep2023

fun main() {
    println(migratoryBirds(arrayOf(1, 1, 2, 2, 3)))
}

fun migratoryBirds(arr: Array<Int>): Int {
    // Write your code here
    val stats = mutableMapOf<Int, Int>()
    arr.toSortedSet().forEach { id ->
        stats[id] = arr.count { it == id }
    }
    val maxValue = stats.values.maxOf { it }
    return stats.entries.first { it.value == maxValue }.key
}