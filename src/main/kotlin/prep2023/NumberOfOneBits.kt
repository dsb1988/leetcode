package prep2023

fun main() {
    println(hammingWeight(-3))
}

fun hammingWeight(n: Int): Int {
    var result = 0
    var num = n
    while (num != 0) {
        num = num and num - 1
        result++
    }
    return result
}
