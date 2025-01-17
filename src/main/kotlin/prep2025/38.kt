package prep2025

fun main() {
    println(countAndSay(10))
}

fun countAndSay(n: Int): String {
    if (n == 1) return "1"

    fun frequencies(num: String): Array<Pair<Int, Int>> { // [num, freq]
        val result = mutableListOf<Pair<Int, Int>>()
        var i = 0
        while (i <= num.lastIndex) {
            var j = i
            do {
                j++
            } while (j <= num.lastIndex && num[j] == num[i])
            result.add(Pair(num[i].code - '0'.code, j - i))
            i = j
        }
        return result.toTypedArray()
    }

    fun rle(frequencies: Array<Pair<Int, Int>>): String {
        if (frequencies.isEmpty()) return ""
        val builder = StringBuilder()
        frequencies.forEach { (num, freq) ->
            builder.append("$freq$num")
        }
        return builder.toString()
    }

    var i = 0
    var num = "1"
    while (i < n - 1) {
        val freq = frequencies(num)
        num = rle(freq)
        i++
    }

    return num
}