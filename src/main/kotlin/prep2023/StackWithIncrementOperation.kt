package prep2023

import java.lang.Integer.min

class CustomStack(private val maxSize: Int) {
    private val stack = IntArray(maxSize)
    private var head = -1

    fun push(x: Int) {
        if (head < maxSize-1) {
            stack[++head] = x
        }
    }

    fun pop(): Int {
        return if (head > -1) {
            stack[head--]
        } else {
            -1
        }
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0..min(k-1, maxSize-1)) {
            stack[i] += `val`
        }
    }
}