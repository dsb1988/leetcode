package prep2024

import models.ListNode
import models.nodeAt
import models.print
import models.size

fun main() {
    val array = arrayOf(1, 2, 3, 4, 5)
    var current: ListNode? = ListNode(array.first())
    val head = current
    current?.next = null
    for (i in 1..array.lastIndex) {
        current?.next = ListNode(array[i])
        current = current?.next
    }

    head?.print()
    val newHead = removeNthFromEnd(head, 2)
    newHead?.print()
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    val size = head.size()
    if (size < n) return head
    if (size == n) {
        val newHead = head.next
        return newHead
    }

    val leftOfRemoval = head.nodeAt(head.size() - n - 1)
    val removal = leftOfRemoval?.next
    leftOfRemoval?.next = removal?.next

    return head
}






