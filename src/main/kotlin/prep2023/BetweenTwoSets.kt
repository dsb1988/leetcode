package prep2023

fun main() {
    println(getTotalX(arrayOf(2, 6), arrayOf(24, 36)))
}

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    // Write your code here
    var result = 0
    val setA = a.toSortedSet()
    val setB = b.toSortedSet()
    for (i in setA.last()..setB.first()) {
        if (setA.valuesFactorOf(i) && i.isFactorOfAll(setB)) {
            result++
        }
    }
    return result
}

fun Int.isFactorOfAll(numbers: Set<Int>): Boolean {
    for (e in numbers) {
        if (!this.isFactorOf(e)) return false
    }
    return true
}

fun Int.isFactorOf(other: Int) = other % this == 0

fun Set<Int>.valuesFactorOf(number: Int): Boolean {
    for (e in this) {
        if (number % e != 0) return false
    }
    return true
}