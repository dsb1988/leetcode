package prep2024

fun main() {
    println(carFleet(10, intArrayOf(6, 8), intArrayOf(3, 2)))
}

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val pairs = position.zip(speed).sortedByDescending { it.first }
    val stack = mutableListOf<Float>()
    pairs.forEach { (pos, speed) ->
        stack.add((target - pos) / speed.toFloat())
        if (stack.size >= 2 && stack[stack.lastIndex] <= stack[stack.lastIndex - 1]) {
            stack.removeLast()
        }
    }
    return stack.size
}