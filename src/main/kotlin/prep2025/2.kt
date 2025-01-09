package prep2025

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    addTwoNumbers(linkedListOf(2, 4, 3), linkedListOf(5, 6, 4)).print()
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var ptr: ListNode? = dummy
    var overflow = 0
    var left = l1
    var right = l2
    while (left != null || right != null || overflow > 0) {
        val leftVal = left?.`val` ?: 0
        val rightVal = right?.`val` ?: 0

        val sum = leftVal + rightVal + overflow

        overflow = sum / 10
        ptr?.next = ListNode(sum % 10)

        ptr = ptr?.next
        left = left?.next
        right = right?.next
    }
    return dummy.next
}