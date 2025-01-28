package prep2025

import java.util.*

fun main() {
//    println(mostBooked(2, arrayOf(intArrayOf(0, 10), intArrayOf(1, 5), intArrayOf(2, 7), intArrayOf(3, 4))))
//    println(mostBooked(2, arrayOf(intArrayOf(0, 10), intArrayOf(1, 2), intArrayOf(12, 14), intArrayOf(13, 15))))
    println(
        mostBooked(
            4,
            arrayOf(intArrayOf(18, 19), intArrayOf(3, 12), intArrayOf(17, 19), intArrayOf(2, 13), intArrayOf(7, 10))
        )
    )
}

fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    meetings.sortBy { it[0] }

    val numOfBookings = IntArray(n) { 0 }
    val freeRooms = PriorityQueue<Int>(n)
    for (room in 0 until n) {
        freeRooms.add(room)
    }
    val busyRooms = PriorityQueue<IntArray> { p1, p2 ->
        if (p1[0] - p2[0] == 0) {
            p1[1] - p2[1]
        } else {
            p1[0] - p2[0]
        }
    } // endTime, room #
    for (meeting in meetings) {
        val startTime = meeting[0]
        val endTime = meeting[1]

        while (busyRooms.isNotEmpty() && busyRooms.peek()[0] <= startTime) {
            val room = busyRooms.poll()[1]
            freeRooms.add(room)
        }

        if (freeRooms.isEmpty()) {
            val room = busyRooms.poll()
            val prevEndTime = room[0]
            val roomNo = room[1]
            busyRooms.add(intArrayOf(prevEndTime + (endTime - startTime), roomNo))
            numOfBookings[roomNo] += 1
        } else {
            val room = freeRooms.poll()
            busyRooms.add(intArrayOf(endTime, room))
            numOfBookings[room] += 1
        }
    }
    return numOfBookings.indexOf(numOfBookings.maxOf { it })
}

