package prep2025

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    val one = linkedListOf(1, 2, 3, 4)
    reorderList(one)
    one.print()
    val two = linkedListOf(1, 2, 3, 4, 5)
    reorderList(two)
    two.print()
}

// L0 -> Ln -> L1 -> Ln-1 ...
fun reorderList(head: ListNode?) {
    if (head == null) return

    // find middle
    var slow = head
    var fast = head.next
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    } // slow == 2nd list head

    var second = slow?.next
    slow?.next = null
    // reverse second list
    var prev: ListNode? = null
    while (second != null) {
        val temp = second.next
        second.next = prev
        prev = second
        second = temp
    }

    // merge lists
    var first = head
    second = prev
    while (second != null) {
        val tempF = first?.next
        val tempS = second.next
        first?.next = second
        second.next = tempF
        first = tempF
        second = tempS
    }
}