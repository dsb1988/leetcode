package prep2024

import kotlin.math.min

fun main() {
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(longestCommonPrefix(arrayOf("reflower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("acc", "aaa", "aaba")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs.first()
    strs.sort()

    val first = strs.first()
    val last = strs.last()
    val minLength = min(first.length, last.length)
    var prefix = ""
    for (i in 0 until minLength) {
        if (first[i] == last[i]) {
            prefix += first[i]
        } else {
            break
        }
    }
    return prefix
}

