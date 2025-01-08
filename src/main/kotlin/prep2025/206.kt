package prep2025

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    val one = linkedListOf(1, 2, 3, 4, 5)
    reverseList(one).print()
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    var newHead = ListNode(head.`val`)
    newHead.next = null

    var ptr = head.next
    while (ptr != null) {
        val temp = ptr.next
        ptr.next = newHead
        newHead = ptr
        ptr = temp
    }
    return newHead
}