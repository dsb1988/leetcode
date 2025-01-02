package prep2024

import kotlin.math.max

fun main() {
    println(characterReplacement("AABABBA", 1))
    println(characterReplacement("ABAB", 2))
    println(characterReplacement("AAAA", 0))
    println(characterReplacement("BAAAB", 2))
}

fun characterReplacement(s: String, k: Int): Int {
    if (s.isEmpty()) return 0

    var result = 0
    val stats = mutableMapOf<Char, Int>()
    var left = 0
    var maxf = 0
    for (right in s.indices) {
        stats[s[right]] = stats.getOrDefault(s[right], 0) + 1
        maxf = max(maxf, stats.getOrDefault(s[right], 0))
        while ((right - left + 1) - maxf > k) {
            if (stats.getOrDefault(s[left], 0) > 0) {
                stats[s[left]] = stats.getOrDefault(s[left], 0) - 1
            }
            left++
        }
        result = max(result, right - left + 1)
    }
    return result
}