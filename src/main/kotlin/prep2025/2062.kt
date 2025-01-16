package prep2025

fun main() {
    println(countVowelSubstrings("cuaieuouac"))
}

fun countVowelSubstrings(word: String): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var result = 0

    var left = 0
    while (left <= word.lastIndex) {
        val charLeft = word[left]
        if (vowels.contains(charLeft)) {
            val stats = hashSetOf<Char>()
            stats.add(charLeft)
            var right = left
            while (right <= word.lastIndex) {
                val charRight = word[right]
                if (vowels.contains(charRight)) {
                    stats.add(charRight)
                    if (stats.containsAll(vowels)) {
                        result++
                    }
                    right++
                } else {
                    break
                }
            }
        }
        left++
    }
    return result
}