package prep2023

import java.util.*

fun main() {
    val queue = Queue()

    for (i in 0..9) {
        queue.enqueue(i)
    }
    for (j in 0..10) {
        println(queue.dequeue())
    }
}

class Queue {
    private val queue = LinkedList<Array<Int?>>()
    private var head = 0
    private var tail = 0

    fun enqueue(value: Int) {
        if (queue.isEmpty()) {
            queue.add(Array(5) { null })
        }
        if (tail > 4) {
            queue.add(Array(5) { null })
            tail = 0
        }
        queue.last[tail] = value
        tail++
    }

    fun dequeue(): Int {
        if (queue.isEmpty()) {
            throw EmptyQueueException()
        } else {
            if (head > 4) {
                queue.removeFirst()
                head = 0
            }
            val result = queue.first[head]
            if (result != null) {
                head++
                return result
            } else {
                throw EmptyQueueException()
            }
        }
    }
}

class EmptyQueueException : RuntimeException()