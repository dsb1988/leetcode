package prep2025

fun main() {
    val string = "PAYPALISHIRING"
    println(convert(string, 3))
    println(convert(string, 4))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    var row = 0
    var d = 1
    val arr = Array(numRows) { mutableListOf<Char>() }

    s.forEach { c ->
        arr[row].add(c)
        if (row == 0) {
            d = 1
        } else if (row == numRows - 1) {
            d = -1
        }
        row += d
    }
    val builder = StringBuilder()
    arr.forEach { line ->
        line.forEach { c ->
            builder.append(c)
        }
    }
    return builder.toString()
}