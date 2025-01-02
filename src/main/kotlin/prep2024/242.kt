package prep2024

fun main() {

}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    if (s.isEmpty() && t.isEmpty()) return true
    if (s == t) return true

    val sStats = hashMapOf<Char, Int>()
    val tStats = hashMapOf<Char, Int>()
    for (i in s.indices) {
        sStats[s[i]] = sStats.getOrDefault(s[i], 0) + 1
        tStats[t[i]] = tStats.getOrDefault(t[i], 0) + 1
    }

    return sStats == tStats
}