package prep2024

import models.ListNode
import models.linkedListOf
import models.print

fun main() {
    println("Reverse Nodes in k-Group")
    val list1 = linkedListOf(1, 2, 3, 4, 5)
    list1.print()

    reverseKGroup(list1, 2).print()
}

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head.size() < k) return head
    if (head.size() == k) return reverseListItems(head, k)

    val pointer = head.nodeAt(k - 1)
    val nextPointer = head.nodeAt(k)
    pointer?.next = null
    val reversed = reverseListItems(head, k)
    reversed.nodeAt(k - 1)?.next = reverseKGroup(nextPointer, k)

    return reversed
}

fun reverseListItems(head: ListNode?, n: Int): ListNode? {
    if (head?.next == null) return head
    if (head.size() < n) return head

    var pointer: ListNode? = head
    var tail: ListNode? = ListNode(head.`val`)
    tail?.next = null
    var counter = 0
    while (counter < n) {
        tail = tail.prependSingle(pointer?.next)
        pointer = pointer?.next
        counter++
    }
    return tail
}

fun ListNode?.prependSingle(node: ListNode?): ListNode? {
    if (this == null) return node
    if (node == null) return this
    val result = ListNode(node.`val`)
    result.next = this
    return result
}

fun ListNode?.size(): Int {
    if (this == null) return 0
    if (this.next == null) return 1
    var counter = 1
    var pointer = this
    do {
        counter++
        pointer = pointer?.next
    } while (pointer?.next != null)
    return counter
}

fun ListNode?.nodeAt(index: Int): ListNode? {
    if (index > this.size() - 1) return null
    if (index == 0) return this
    var pointer = this
    var seekIndex = 0
    do {
        seekIndex++
        pointer = pointer?.next
    } while (seekIndex != index)
    return pointer
}
