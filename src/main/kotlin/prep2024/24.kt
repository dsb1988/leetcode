package prep2024

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    println("Swap Nodes in Pairs")
    val list = linkedListOf(listOf(1, 2, 3, 4))
    list.print()
    val swapped = swapPairs(list)
    swapped.print()
}

fun swapPairs(head: ListNode?): ListNode? {
    fun split(head: ListNode?): List<ListNode?> {
        if (head?.next == null) return listOf(head)

        val nextHead = head.next?.next
        val newHead = head.next
        newHead?.next = head
        head.next = null
        return listOf(newHead) + split(nextHead)
    }

    val split = split(head)
    if (split.isEmpty()) return null
    var i = 0
    while (i < split.size - 1) {
        val left = split[i]
        val right = split[i + 1]
        left?.next?.next = right

        i++
    }
    return split.first()
}
