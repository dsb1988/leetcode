package prep2024

fun main() {
    println(letterCombinations("2"))
    println(letterCombinations("23"))
//    println(letterCombinations("278"))
}

/**
 * 2 - abc
 * 3 - def
 * 4 - ghi
 * 5 - jkl
 * 6 - mno
 * 7 - pqrs
 * 8 - tuv
 * 9 - wxyz
 */

/**
 * ad ae af
 * bd be bf
 * cd ce cf
 */


fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()
    val mapping = hashMapOf<Char, String>()
    mapping['2'] = "abc"
    mapping['3'] = "def"
    mapping['4'] = "ghi"
    mapping['5'] = "jkl"
    mapping['6'] = "mno"
    mapping['7'] = "pqrs"
    mapping['8'] = "tuv"
    mapping['9'] = "wxyz"

    val words = mutableListOf<String>()
    digits.forEach { c -> words.add(mapping.getOrDefault(c, "")) }
    return words.first().map { combine(it.toString(), words.drop(1)) }.flatten()
}

fun combine(left: String, right: List<String>): List<String> {
    if (right.isEmpty()) return left.map { it.toString() }

    return if (right.size == 1) {
        right.first().map { left + it }
    } else {
        combine(left, right.take(1)).flatMap { combine(it, right.drop(1)) }
    }
}
