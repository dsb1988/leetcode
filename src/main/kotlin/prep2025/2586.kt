package prep2025

fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var result = 0
    for (i in left..right) {
        val word = words[i]
        if (vowels.contains(word[0]) && vowels.contains(word.last())) {
            result++
        }
    }
    return result
}