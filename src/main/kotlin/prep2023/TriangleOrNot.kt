package prep2023

fun main() {
    val a = intArrayOf(7, 10, 7)
    val b = intArrayOf(2, 3, 4)
    val c = intArrayOf(2, 7, 4)
    println(triangleOrNot(a, b, c))
}

fun triangleOrNot(sidesA: IntArray, sidesB: IntArray, sidesC: IntArray): String {

    for (i in sidesA.indices) {
        val a = sidesA[i]
        val b = sidesB[i]
        val c = sidesC[i]
        return if (a * a + b * b == c * c) "Yes" else "N"
    }
    return "No"
}