package prep2024

import models.ListNode

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