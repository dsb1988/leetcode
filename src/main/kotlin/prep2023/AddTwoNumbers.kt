package prep2023

fun main() {
    val leftArr = arrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
    val rightArr = arrayOf(9, 9, 9, 9)

    val left = ListNode(leftArr.first())
    var prev = left
    for (i in 1 until leftArr.size) {
        val current = ListNode(leftArr[i])
        prev.next = current
        prev = current
    }

    val right = ListNode(rightArr.first())
    prev = right
    for (j in 1 until rightArr.size) {
        val current = ListNode(rightArr[j])
        prev.next = current
        prev = current
    }

    addTwoNumbers(left, right)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    return when {
        l1 == null -> l2
        l2 == null -> l1
        else -> {
            val firstSum = (l1.`val` + l2.`val`) % 10
            var overflow = if ((l1.`val` + l2.`val`) > 9) 1 else 0
            val result = ListNode(firstSum)
            var left = l1.next
            var right = l2.next
            var current = result
            while (true) {
                if (left == null && right == null) break
                val leftDigit = left?.`val` ?: 0
                val rightDigit = right?.`val` ?: 0
                val sum = (leftDigit + rightDigit + overflow) % 10
                overflow = if ((leftDigit + rightDigit + overflow) > 9) 1 else 0
                val nextValue = ListNode(sum)
                current.next = nextValue
                current = nextValue
                left = left?.next
                right = right?.next
            }
            if (overflow > 0) {
                current.next = ListNode(1)
            }
            result
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode.hasNext() = next == null