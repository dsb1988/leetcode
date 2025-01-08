package prep2025

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    val one = linkedListOf(1, 2, 3, 4, 5)
    removeNthFromEnd(one, 2).print()

    val two = linkedListOf(1)
    removeNthFromEnd(two, 1).print()
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var size = 0
    var ptr = head
    while (ptr != null) {
        size++
        ptr = ptr.next
    }

    var seek = 0
    ptr = head
    var prev: ListNode? = null
    while (seek < size - n && ptr != null) {
        prev = ptr
        ptr = ptr.next
        seek++
    }
    if (prev == null) {
        // Removing 1st element
        return ptr?.next
    } else {
        prev.next = ptr?.next
    }

    return head
}