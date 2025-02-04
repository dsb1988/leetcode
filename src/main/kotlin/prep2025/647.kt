package prep2025

fun main() {
    println(countSubstrings("aaa"))
}

fun countSubstrings(s: String): Int {
    var result = 0

    fun checkPalindrome(s: String, midLeft: Int, midRight: Int) {
        var left = midLeft
        var right = midRight
        while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
            result++
            left--
            right++
        }
    }

    var current = 0
    while (current <= s.lastIndex) {
        checkPalindrome(s, current, current)
        if (current < s.lastIndex) {
            checkPalindrome(s, current, current + 1)
        }
        current++
    }
    return result
}