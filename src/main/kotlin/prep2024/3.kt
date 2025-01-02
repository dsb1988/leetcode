package prep2024

import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring("qrsvbspk"))
}

// "abcabcbb"

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    var left = 0
    var max = 0
    var right = left
    val stats = mutableSetOf<Char>()
    while (right < s.length) {
        val char = s[right]
        if (!stats.contains(char)) {
            stats.add(char)
            max = max(max, stats.size)
        } else {
            while (s[left] != char) {
                stats.remove(s[left])
                left++
            }
            left++
            stats.add(s[right])
            max = max(max, stats.size)
        }
        right++
    }
    return max
}