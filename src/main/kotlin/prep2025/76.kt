package prep2025

fun main() {
    println(minWindow("ADOBECODEBANC", "ABC"))
    println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"))
}

fun minWindow(s: String, t: String): String {
    fun String.toHashMap(): Map<Char, Int> {
        val result = hashMapOf<Char, Int>()
        this.forEach { c ->
            result[c] = result.getOrDefault(c, 0) + 1
        }
        return result
    }

    fun Map<Char, Int>.containsAll(other: Map<Char, Int>): Boolean {
        var result = true
        other.forEach { (k, v) ->
            if ((this[k] ?: 0) < v) {
                result = false
                return@forEach
            }
        }
        return result
    }

    var result = ""
    var minLength = Int.MAX_VALUE
    val tStats = t.toHashMap()
    var left = 0
    var right = 0
    val sStats = hashMapOf<Char, Int>()
    while (right <= s.lastIndex) {
        sStats[s[right]] = sStats.getOrDefault(s[right], 0) + 1
        if (sStats.containsAll(tStats)) {
            while (left <= s.lastIndex && sStats.containsAll(tStats)) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1
                    result = s.substring(left, right + 1)
                }
                val leftCount = sStats.getOrDefault(s[left], 0)
                if (leftCount > 0) {
                    sStats[s[left]] = leftCount - 1
                }
                left++
            }
        }
        right++
    }
    return result
}