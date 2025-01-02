package prep2024

import models.ListNode

fun main() {
    println("Merge Two Sorted Lists")
}

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
        val leftValue = left?.`val` ?: Int.MAX_VALUE
        val rightValue = right?.`val` ?: Int.MAX_VALUE
        if (leftValue < rightValue) {
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