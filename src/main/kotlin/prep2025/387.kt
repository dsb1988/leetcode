package prep2025

fun firstUniqChar(s: String): Int {
    val stats = hashMapOf<Char, Pair<Int, Int>>()
    s.forEachIndexed { index, c ->
        val entry = stats.getOrDefault(c, Pair(0, -1))
        stats[c] = Pair(entry.first + 1, index)
    }
    return stats.filter { (_, v) -> v.first == 1 }.minOfOrNull { it.value.second } ?: -1
}