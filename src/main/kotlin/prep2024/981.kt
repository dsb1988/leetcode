package prep2024

import kotlin.math.max

fun main() {

}

class TimeMap() {
    private val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val list = map.getOrDefault(key, mutableListOf())
        list.add(Pair(timestamp, value))
        map[key] = list
    }

    fun get(key: String, timestamp: Int): String {
        val list = map.getOrDefault(key, mutableListOf())
        if (list.isEmpty()) return ""

        return binarySearch(list, timestamp)
    }

    private fun binarySearch(list: List<Pair<Int, String>>, target: Int): String {
        if (list.isEmpty()) return ""
        if (list.first().first <= target && list.last().first <= target) {
            return list.last().second
        }
        var result = ""
        var left = 0
        var right = list.lastIndex
        while (left <= right) {
            val mid = (left + right) / 2
            if (list[mid].first == target) return list[mid].second
            if (list[mid].first > target) {
                right = mid - 1
            } else {
                result = list[mid].second
                left = mid + 1
            }
        }
        return result
    }
}