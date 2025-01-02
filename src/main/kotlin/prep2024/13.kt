package prep2024

fun romanToInt(s: String): Int {
    var input = s
    var result = 0
    if (input.contains("CM")) {
        input = input.replace("CM", "")
        result += 900
    }
    if (input.contains("CD")) {
        input = input.replace("CD", "")
        result += 400
    }
    if (input.contains("XC")) {
        input = input.replace("XC", "")
        result += 90
    }
    if (input.contains("XL")) {
        input = input.replace("XL", "")
        result += 40
    }
    if (input.contains("IX")) {
        input = input.replace("IX", "")
        result += 9
    }
    if (input.contains("IV")) {
        input = input.replace("IV", "")
        result += 4
    }
    var i = 0
    while (i < input.length) {
        when {
            input[i] == 'M' -> result += 1000
            input[i] == 'D' -> result += 500
            input[i] == 'C' -> result += 100
            input[i] == 'L' -> result += 50
            input[i] == 'X' -> result += 10
            input[i] == 'V' -> result += 5
            input[i] == 'I' -> result += 1
        }
        i++
    }
    return result
}