package prep2023

fun main() {
    val input = arrayOf("ababaa")
    val result = commonPrefix(input)
    println("Result: ${result.contentToString()}")
}

fun commonPrefix(inputs: Array<String>): Array<Int> {
    // Write your code here
    val result = Array(inputs.size) { 0 }
    inputs.forEachIndexed { index, input ->
        var total = 0
        for (i in input.indices) {
            if (input[i] == input[0]) {
                var j = i
                var k = 0
                while (j < input.length) {
                    if (input[j] == input[k]) {
                        j++
                        k++
                    } else {
                        break
                    }
                }
                total += k
            }
        }
        result[index] = total
    }
    return result
}