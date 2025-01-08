package prep2025

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    val one = linkedListOf(1, 2, 4)
    val two = linkedListOf(1, 3, 4)
    mergeTwoLists(one, two).print()
}

// two pointers left and right, compare values one-by-one, insert into a new list
// move pointers
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    var left = list1
    var right = list2

    val head: ListNode?
    if (left.`val` < right.`val`) {
        head = left
        left = left.next
    } else {
        head = right
        right = right.next
    }

    var current = head
    while (left != null || right != null) {
        val leftVal = left?.`val` ?: Int.MAX_VALUE
        val rightVal = right?.`val` ?: Int.MAX_VALUE
        if (leftVal < rightVal) {
            current?.next = left
            current = current?.next
            left = left?.next
        } else {
            current?.next = right
            current = current?.next
            right = right?.next
        }
    }
    return head
}