package prep2025

fun main() {

}

fun makeSmallestPalindrome(s: String): String {
    val arr = s.toCharArray()
    var left = 0
    var right = s.lastIndex
    while (left < right) {
        val leftChar = arr[left]
        val rightChar = arr[right]
        if (leftChar != rightChar) {
            if (leftChar.code < rightChar.code) {
                arr[right] = leftChar
            } else {
                arr[left] = rightChar
            }
        }
        left++
        right--
    }
    return String(arr)
}