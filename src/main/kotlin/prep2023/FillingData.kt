package prep2023

fun main() {
    val reader =
        object {}.javaClass.getResourceAsStream("input000.txt")?.bufferedReader() ?: error("Can't start reader")
    val readingsCount = reader.readLine().trim().toInt()
    val readings = Array(readingsCount) { "" }
    for (i in 0 until readingsCount) {
        readings[i] = reader.readLine()
    }
    calcMissing(readings)
}

fun calcMissing(readings: Array<String>): Unit {
    // Write your code here
    val parsed = mutableListOf<Reading>()
    readings.forEachIndexed { index, reading ->
        val split = reading.split("\t")
        val value = if (split[1].contains("Missing")) null else split[1].toFloat()
        parsed.add(Reading(index, value))
    }

    val result = mutableListOf<Reading>()

    parsed.forEach { reading ->
        if (reading.value == null) {
            val x = reading.day
            val left = parsed.slice(0 until reading.day).reversed().first { it.value != null }
            val right = parsed.slice(reading.day until parsed.size).first { it.value != null }

            val x1 = left.day // day with non-null value to the left
            val x2 = right.day // day with non-null value to the right
            val y1 = left.value ?: 0f // non-null value to the left
            val y2 = right.value ?: 0f // non-null value to the right

            val interpolated = y1 + (x - x1) * (y2 - y1) / (x2 - x1)
            val calculated = Reading(x, interpolated)
            parsed[x] = calculated
            result.add(calculated)
        }
    }
    result.forEach {
        println(it.value)
    }
}

data class Reading(val day: Int, val value: Float?)