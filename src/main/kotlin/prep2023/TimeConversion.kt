package prep2023

fun main() {
    println(timeConversion("07:05:45PM"))
}

fun timeConversion(s: String): String {
    // Write your code here
    val isAm = s.contains("AM")
    val split = s.substring(0..s.length - 3).split(":")
    val hours = split[0].toInt()
    val minutes = split[1]
    val seconds = split[2]
    var result = ""
    when {
        isAm && hours == 12 -> result += "00"
        isAm && hours < 12 -> result += "0$hours"
        !isAm && hours == 12 -> result += hours
        !isAm && hours < 12 -> result += hours + 12
    }
    result += ":$minutes:$seconds"
    return result
}
