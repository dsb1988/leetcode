package prep2024

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    println("Merge k Sorted Lists")

    val list1 = emptyList<Int>()
    val linked1 = linkedListOf(list1)
    linked1.print()

    val list2 = listOf(-2)
    val linked2 = linkedListOf(list2)
    linked2.print()

    val list3 = listOf(-3, -2, 1)
    val linked3 = linkedListOf(list3)
    linked3.print()

    val merged = mergeKLists(arrayOf(linked1, linked2, linked3))
    merged.print()
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    if (lists.none { it != null }) return null
    if (lists.size == 1) return lists.first()

    val memo = sortedMapOf<Int, Int>()
    for (list in lists) {
        var current = list
        while (current != null) {
            current.let {
                val number = it.`val`
                val counter = memo.getOrDefault(number, 0)
                if (counter > 0) {
                    memo[number] = counter + 1
                } else {
                    memo[number] = 1
                }
            }
            current = current.next
        }
    }

    val head = ListNode(memo.keys.first())
    var current: ListNode? = head
    memo.forEach { (t, u) ->
        for (i in 0 until u) {
            current?.next = ListNode(t)
            current = current?.next
        }
    }

    return head.next
}