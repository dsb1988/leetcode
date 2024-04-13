package prep2023

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var result = ""
    if (strs.contains(result)) return result
    val minLength = strs.minOf { it.length }
    for (i in 0 until minLength) {
        val c = strs.first()[i]
        for (j in 1 until strs.size) {
            if (c != strs[j][i]) {
                return result
            }
        }
        result += c
    }
    return result
}