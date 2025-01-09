package prep2025

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null

    companion object {
        fun listOf(vararg values: Pair<Int, Int?>): Node? {
            if (values.isEmpty()) return null
            val list = mutableListOf<Node>()
            val head = Node(values.first().first)
            list.add(head)
            var ptr = head
            for (i in 1..values.lastIndex) {
                ptr.next = Node(values[i].first)
                ptr = ptr.next as Node
                list.add(ptr)
            }
            values.forEachIndexed { index, (_, random) ->
                if (random != null) {
                    list[index].random = list[random]
                }
            }
            return head
        }
    }
}

fun Node?.print() {
    if (this == null) {
        println("[]")
        return
    }
    if (this.next == null) {
        println("[$`val`]")
        return
    }
    var pointer: Node? = this
    while (pointer != null) {
        if (pointer.next != null) {
            print("[${pointer.`val`}, ${pointer.random?.`val`}]->")
        } else {
            print("[${pointer.`val`}, ${pointer.random?.`val`}]")
        }
        pointer = pointer.next
    }
    println()
}

fun main() {
    val one = Node.listOf(Pair(7, null), Pair(13, 0), Pair(11, 4), Pair(10, 2), Pair(1, 0))
    one.print()
    val copy = copyRandomList(one)
    copy.print()
}

val map = hashMapOf<Node, Node>()

fun copyRandomList(node: Node?): Node? {
    if (node == null) return null

    if (map.contains(node)) {
        return map[node]
    }

    val newNode = Node(node.`val`)
    map[node] = newNode
    newNode.next = copyRandomList(node.next)
    newNode.random = copyRandomList(node.random)

    return newNode
}