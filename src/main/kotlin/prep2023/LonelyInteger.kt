package prep2023

fun main() {
    println(lonelyInteger(arrayOf(0, 0, 1, 2, 1)))
}

fun lonelyInteger(a: Array<Int>): Int {
    // Write your code here
    if (a.size == 1) return a[0]
    a.sort()
    for (elem in a) {
        if (a.count { it == elem } == 1) {
            return elem
        }
    }
    return a[0]
}