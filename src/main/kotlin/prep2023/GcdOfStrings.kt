package prep2023

fun main() {
    val str1 = "ABCABC"
    val str2 = "ABC"
    gcdOfStrings(str1, str2)
}

fun gcdOfStrings(str1: String, str2: String): String {
    return if (str1+str2 != str2+str1) {
        ""
    } else {
        str1.substring(0, gcd(str1.length, str2.length))
    }
}

fun gcd(a: Int, b: Int): Int = if (a == 0) b else gcd(b % a, a)