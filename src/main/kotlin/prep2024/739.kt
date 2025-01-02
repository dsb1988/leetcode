package prep2024

fun main() {
    println(dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).contentToString())
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    if (temperatures.isEmpty()) return intArrayOf()
    val result = IntArray(temperatures.size) { 0 }
    val stack = mutableListOf<Pair<Int, Int>>()
    stack.add(Pair(0, temperatures.first()))
    temperatures.forEachIndexed { index, temp ->
        while (stack.isNotEmpty() && stack.last().second < temp) {
            val last = stack.last()
            result[last.first] = index - last.first
            stack.removeLast()
        }
        stack.add(Pair(index, temp))
    }
    return result
}