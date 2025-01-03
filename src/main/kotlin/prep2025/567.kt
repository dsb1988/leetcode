package prep2025

fun main() {
    println(checkInclusion("ab", "eidbaooo"))
    println(checkInclusion("hello", "ooolleoooleh"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.isEmpty()) return false
    if (s2.isEmpty()) return false

    fun <K, V> mapsEqual(left: Map<K, V>, right: Map<K, V>): Boolean {
        var result = true
        left.forEach { (k1, v1) ->
            if (right[k1] != v1) {
                result = false
                return@forEach
            }
        }
        return result
    }

    val s1Stats = hashMapOf<Char, Int>()
    s1.forEach { c ->
        s1Stats[c] = s1Stats.getOrDefault(c, 0) + 1
    }
    var l = 0
    var r = 0
    val s2Stats = hashMapOf<Char, Int>()
    while (r <= s2.lastIndex) {
        if (r - l + 1 <= s1.length) {
            s2Stats[s2[r]] = s2Stats.getOrDefault(s2[r], 0) + 1
            if (mapsEqual(s1Stats, s2Stats)) {
                return true
            }
            r++
        } else {
            if (s2Stats.getOrDefault(s2[l], 0) > 1) {
                s2Stats[s2[l]] = s2Stats.getOrDefault(s2[l], 0) - 1
            } else {
                s2Stats.remove(s2[l])
            }
            l++
        }
    }
    return false
}