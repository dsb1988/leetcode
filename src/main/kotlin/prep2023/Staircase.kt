package prep2023

fun main() {
    staircase(4)
}

fun staircase(n: Int): Unit {
    // Write your code here
    for (i in n downTo 1) {
        for (j in 1..n) {
            if (j < i) print(" ") else print("#")
        }
        println()
    }
}