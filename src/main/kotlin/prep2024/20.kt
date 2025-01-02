package prep2024

fun main() {
    println("Valid Parentheses")
    println(isValid("()[]{}"))
    println(isValid("([{}])"))
}

fun isValid(s: String): Boolean {
    val deque = mutableListOf<Char>()
    s.forEach { c ->
        if (deque.isEmpty()) {
            deque.add(c)
        } else {
            when {
                c == ')' && deque.last() == '(' -> deque.removeLast()
                c == '}' && deque.last() == '{' -> deque.removeLast()
                c == ']' && deque.last() == '[' -> deque.removeLast()
                else -> deque.add(c)
            }
        }
    }
    return deque.size == 0
}
