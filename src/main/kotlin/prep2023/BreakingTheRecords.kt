package prep2023

fun main() {
    println(breakingRecords(arrayOf(12, 24, 10, 24)).contentToString())
}

fun breakingRecords(scores: Array<Int>): Array<Int> {
    // Write your code here
    if (scores.isEmpty()) return emptyArray()
    var minScore = scores.first()
    var maxScore = scores.first()
    var minBreak = 0
    var maxBreak = 0
    for (score in scores) {
        if (score < minScore) {
            minScore = score
            minBreak++
        }
        if (score > maxScore) {
            maxScore = score
            maxBreak++
        }
    }
    return arrayOf(maxBreak, minBreak)
}