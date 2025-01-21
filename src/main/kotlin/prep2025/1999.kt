package prep2025

fun main() {
//    println(findInteger(2, 0, 2))
    println(findInteger(5, 2, 8))
}

fun findInteger(k: Int, digit1: Int, digit2: Int): Int {
    if (digit1 == 0 && digit2 == 0) {
        return -1
    }
    if (digit1 > digit2) {
        return findInteger(k, digit2, digit1)
    }

    val queue = mutableListOf<Long>()
    queue.add(0L)
    while (true) {
        val num = queue.removeFirst()
        if (num > Int.MAX_VALUE) {
            return -1
        }
        if (num > k && num % k == 0L) {
            return num.toInt()
        }
        queue.add(num * 10 + digit1)
        if (digit1 != digit2) {
            queue.add(num * 10 + digit2)
        }
    }
}