package prep2025

fun reverseWords(s: String): String {
    return s.split(" ")
        .joinToString(" ") { it.reversed() }
}