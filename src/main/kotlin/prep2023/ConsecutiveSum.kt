package prep2023

fun consecutive(num: Long): Int {
    // Write your code here
    var result = 0
//    var i = 2
//    while (i*(i+1)/2 <= num) {
//        if ((num-i*(i+1)/2) % i == 0L) {
//            result++
//        }
//        i++
//    }

    (2..num).takeWhile { i ->
        i * (i + 1) / 2 <= num
    }.forEach { i ->
        if ((num - i * (i + 1) / 2) % i == 0L) {
            result++
        }
    }

    return result + 1
}