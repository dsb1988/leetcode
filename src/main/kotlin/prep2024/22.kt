package prep2024

fun main() {
    println("Generate Parentheses")
    println(generateParenthesis(1))
    println(generateParenthesis(2))
    println(generateParenthesis(3))
}

fun generateParenthesis(n: Int): List<String> {
    fun generate(s: String, openCount: Int, closeCount: Int): List<String> {
        if (openCount == closeCount && openCount == n) {
            return listOf(s)
        }

        if (s.isEmpty()) return generate("(", openCount + 1, closeCount)

        if (openCount == closeCount && openCount < n) {
            return generate("$s(", openCount + 1, closeCount)
        }

        if (openCount == n) {
            return generate("$s)", openCount, closeCount + 1)
        }

        return generate("$s(", openCount + 1, closeCount) + generate("$s)", openCount, closeCount + 1)
    }
    return generate("", openCount = 0, closeCount = 0)
}
