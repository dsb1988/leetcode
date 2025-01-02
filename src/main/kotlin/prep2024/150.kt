package prep2024

fun main() {
    val one = arrayOf("2", "1", "+", "3", "*")
    println(evalRPN(one))
    val two = arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
    println(evalRPN(two))
}

fun evalRPN(tokens: Array<String>): Int {
    if (tokens.isEmpty()) return 0
    val stack = mutableListOf<Int>()

    tokens.forEach { token ->
        when (token) {
            "+" -> {
                val right = stack.last()
                stack.removeLast()
                val left = stack.removeLast()
                stack.add(left + right)
            }

            "-" -> {
                val right = stack.last()
                stack.removeLast()
                val left = stack.removeLast()
                stack.add(left - right)
            }

            "*" -> {
                val right = stack.last()
                stack.removeLast()
                val left = stack.removeLast()
                stack.add(left * right)
            }

            "/" -> {
                val right = stack.last()
                stack.removeLast()
                val left = stack.removeLast()
                stack.add(left / right)
            }

            else -> stack.add(token.toInt())
        }
    }
    return stack.last()
}