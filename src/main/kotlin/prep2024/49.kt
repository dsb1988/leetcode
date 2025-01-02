package prep2024

fun main() {
    val data = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = groupAnagrams(data)
    println(result)
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    return strs.groupBy { it.toMap() }.map { it.value }
}

fun String.toMap(): MutableMap<Char, Int> {
    val result = mutableMapOf<Char, Int>()
    this.forEach { char -> result[char] = result.getOrDefault(char, 0) + 1 }
    return result
}
