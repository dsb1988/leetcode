package prep2023

fun main() {
    val matrix = arrayOf(
        arrayOf(112, 42, 83, 119),
        arrayOf(56, 125, 56, 49),
        arrayOf(15, 78, 101, 43),
        arrayOf(62, 98, 114, 108)
    )
    for (i in matrix.indices) {
        println(matrix[i].contentToString())
    }
    println("-------")
    println(flippingMatrix(matrix))
}

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    // Write your code here
    var result = 0

    reverseColumn(matrix, 2)
    reverseRow(matrix, 0)
    for (i in matrix.indices) {
        println(matrix[i].contentToString())
    }

    for (j in 0 until matrix.size / 2) {
        for (k in 0 until matrix.size / 2) {
            result += matrix[j][k]
        }
    }

    return result
}

fun reverseColumn(matrix: Array<Array<Int>>, col: Int) {
    val column = Array(matrix.size) { 0 }
    for (i in matrix.indices) {
        column[i] = matrix[i][col]
    }
    column.reverse()
    for (i in matrix.indices) {
        matrix[i][col] = column[i]
    }
}

fun reverseRow(matrix: Array<Array<Int>>, rowIndex: Int) {
    val row = matrix[rowIndex]
    row.reverse()
    matrix[rowIndex] = row
}