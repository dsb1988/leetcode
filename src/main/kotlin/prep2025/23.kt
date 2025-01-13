package prep2025

import models.ListNode

// with hash-map solution time complexity is O(n * k)
// optimization is to merge-sort sub-lists until there's one final list
// complexity is O(n log k)
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    return doMergeKLists(lists, 0, lists.lastIndex)
}

fun doMergeKLists(lists: Array<ListNode?>, left: Int, right: Int): ListNode? {
    if (left == right) return lists[left]
    if (right - left == 1) return mergeLists(lists[left], lists[right])

    val mid = (right + left) / 2
    val leftList = doMergeKLists(lists, left, mid)
    val rightList = doMergeKLists(lists, mid + 1, right)
    return mergeLists(leftList, rightList)
}


fun mergeLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    var left = l1
    var right = l2
    val head: ListNode?
    if (left.`val` < right.`val`) {
        head = left
        left = left.next
    } else {
        head = right
        right = right.next
    }
    var ptr = head
    while (left != null || right != null) {
        val leftVal = left?.`val` ?: Int.MAX_VALUE
        val rightVal = right?.`val` ?: Int.MAX_VALUE
        if (leftVal < rightVal) {
            ptr?.next = left
            ptr = ptr?.next
            left = left?.next
        } else {
            ptr?.next = right
            ptr = ptr?.next
            right = right?.next
        }
    }
    return head
}