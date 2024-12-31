package models

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode?.print() {
    if (this == null) {
        println("[]")
        return
    }
    if (this.next == null) {
        println("[$`val`]")
        return
    }
    var pointer: ListNode? = this
    while (pointer != null) {
        if (pointer.next != null) {
            print("[${pointer.`val`}]->")
        } else {
            print("[${pointer.`val`}]")
        }
        pointer = pointer.next
    }
    println()
}

fun ListNode.size(): Int {
    if (this.next == null) return 1
    var counter = 1
    var current: ListNode? = this.next
    while (current != null) {
        current = current.next
        counter++
    }
    return counter
}

fun ListNode.nodeAt(index: Int): ListNode? {
    if (index > this.size() - 1) return null
    var counter = 0
    var seek: ListNode? = this
    while (counter != index) {
        seek = seek?.next
        counter++
    }
    return seek
}

fun linkedListOf(list: List<Int>): ListNode? {
    if (list.isEmpty()) return null
    if (list.size == 1) return ListNode(list.first())

    val result = ListNode(list.first())
    var current: ListNode? = result
    for (i in 1..list.lastIndex) {
        current?.next = ListNode(list[i])
        current = current?.next
    }
    return result
}

fun linkedListOf(vararg numbers: Int): ListNode? {
    val dummyHead = ListNode(Int.MIN_VALUE)
    var pointer: ListNode? = dummyHead
    for (number in numbers) {
        pointer?.next = ListNode(number)
        pointer = pointer?.next
    }
    return dummyHead.next
}
