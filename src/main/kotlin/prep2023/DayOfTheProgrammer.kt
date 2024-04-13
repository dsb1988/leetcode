package prep2023

fun main() {
    println(dayOfProgrammer(1984))
}

fun dayOfProgrammer(year: Int): String {
    // Write your code here
    var result = ""
    if (year < 1700) return result
    when {
        year < 1918 && year.isJulianLeapYear() ||
                year > 1918 && year.isGregorianLeapYear() -> {
            result = "12.09.$year"
        }

        year < 1918 && !year.isJulianLeapYear() ||
                year > 1918 && !year.isGregorianLeapYear() -> {
            result = "13.09.$year"
        }

        year == 1918 -> {
            result = "26.09.$year"
        }
    }
    return result
}

fun Int.isJulianLeapYear() = this % 4 == 0
fun Int.isGregorianLeapYear() = this % 400 == 0 || (this % 4 == 0 && this % 100 != 0)