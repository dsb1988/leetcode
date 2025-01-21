package prep2025

fun main() {
    println(secondsToRemoveOccurrences("0110101"))
}

fun secondsToRemoveOccurrences(s: String): Int {
    var result = 0
    var str = s
    while (str.contains("01")) {
        str = str.replace("01", "10")
        result++
    }
    return result
}
