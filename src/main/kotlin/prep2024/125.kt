package prep2024

fun main() {
//    val one = "A man, a plan, a canal: Panama"
//    println(isPalindrome(one))
    val two = "0P"
    println(isPalindrome(two))
}

fun isPalindrome(s: String): Boolean {
    val processed = s.lowercase().filter { it.isLetter() || it.isDigit() }
    var left = 0
    var right = processed.lastIndex
    while (left <= right) {
        if (processed[left] == processed[right]) {
            left++
            right--
        } else {
            return false
        }
    }
    return true
}
