package prep2023

fun main() {
    println(
        birthday(
            arrayOf(
                2,
                2,
                2,
                1,
                3,
                2,
                2,
                3,
                3,
                1,
                4,
                1,
                3,
                2,
                2,
                1,
                2,
                2,
                4,
                2,
                2,
                3,
                5,
                3,
                4,
                3,
                2,
                1,
                4,
                5,
                4
            ), 10, 4
        )
    )
}

fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    // Write your code here
    if (s.isEmpty()) return 0
    if (s.size == 1) {
        return if (s[0] == d) {
            1
        } else {
            0
        }
    }
    var result = 0
    for (i in 0..s.size - m) {
        val test = s.slice(i until i + m)
        if (test.sum() == d) {
            result++
        }
    }
    return result
}