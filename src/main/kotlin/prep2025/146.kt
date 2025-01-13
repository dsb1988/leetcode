package prep2025

fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.get(1)
    cache.put(3, 3)
    cache.get(2)
}

// cache is a hash map of (key, node)
// history is a doubly-linked list, most left is LRU, most right is MRU
// insert at the most right
class CacheNode(val key: Int, val value: Int) {
    var next: CacheNode? = null
    var prev: CacheNode? = null
}

class LRUCache(private val capacity: Int) {
    private val cache = HashMap<Int, CacheNode>() // key, (value, rank)
    private var left = CacheNode(0, 0)
    private var right = CacheNode(0, 0)

    init {
        left.next = right
        right.prev = left
    }

    private fun insertNode(node: CacheNode) {
        val prev = right.prev
        prev?.next = node
        node.prev = prev
        node.next = right
        right.prev = node
    }

    private fun removeNode(node: CacheNode) {
        val prev = node.prev
        val next = node.next
        if (prev != null) {
            prev.next = next
        }
        if (next != null) {
            next.prev = prev
        }
    }

    fun get(key: Int): Int {
        if (cache.contains(key)) {
            val node = cache.getOrDefault(key, CacheNode(0, 0))
            removeNode(node)
            insertNode(node)
            return node.value
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            val node = cache.getOrDefault(key, CacheNode(0, 0))
            removeNode(node)
        }
        val newNode = CacheNode(key, value)
        cache[key] = newNode
        insertNode(newNode)
        if (cache.values.size > capacity) {
            val lru = left.next ?: CacheNode(-1, -1)
            removeNode(lru)
            cache.remove(lru.key)
        }
    }
}