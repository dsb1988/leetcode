package prep2025

fun main() {
    println(
        vowelStrings(
            arrayOf("aba", "bcb", "ece", "aa", "e"),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1))
        ).contentToString()
    )
}

fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    fun String.isVowelString(): Boolean {
        if (this.isEmpty()) return false
        return vowels.contains(this.first()) && vowels.contains(this.last())
    }

    val prefixSums = hashMapOf<Int, Int>()
    prefixSums[0] = 0
    var sum = 0
    words.forEachIndexed { index, word ->
        if (word.isVowelString()) {
            sum += 1
        }
        prefixSums[index + 1] = sum
    }

    val result = IntArray(queries.size)
    queries.forEachIndexed { index, query ->
        val left = query[0]
        val right = query[1]
        val diff = prefixSums.getOrDefault(right + 1, 0) - prefixSums.getOrDefault(left, 0)
        result[index] = diff
    }
    return result
}