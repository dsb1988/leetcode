package prep2025

import models.ListNode

// create dummy, create helper to get node at index
// remember previous node, reverse group after it
// reconnect previous.next, update previous node
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head

    var groupPrev: ListNode? = dummy
    while (true) {
        val kNode = nodeAt(groupPrev, k) ?: break
        val groupNext = kNode.next

        var prev = groupNext
        var ptr: ListNode? = groupPrev?.next
        while (ptr != groupNext) {
            val tmp = ptr?.next
            ptr?.next = prev
            prev = ptr
            ptr = tmp
        }

        val oldTail: ListNode? = groupPrev?.next
        groupPrev?.next = kNode
        groupPrev = oldTail
    }
    return dummy.next
}

fun nodeAt(head: ListNode?, index: Int): ListNode? {
    if (head == null) return null
    if (index == 0) return head

    var seek = 0
    var ptr = head
    while (seek < index) {
        ptr = ptr?.next
        seek++
    }
    return ptr
}