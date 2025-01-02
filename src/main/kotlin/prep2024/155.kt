package prep2024

import kotlin.math.min

fun main() {

}

class MinStack() {
    data class StackNode(val value: Int, val min: Int)

    private var stack = mutableListOf<StackNode>()
    private var stackMin = Integer.MAX_VALUE

    fun push(`val`: Int) {
        stackMin = min(stackMin, `val`)
        stack.add(StackNode(`val`, stackMin))
    }

    fun pop() {
        stack.removeLast()
        if (stack.isNotEmpty()) {
            stackMin = stack.last().min
        } else {
            stackMin = Integer.MAX_VALUE
        }
    }

    fun top(): Int {
        return stack.last().value
    }

    fun getMin(): Int {
        return stackMin
    }
}

