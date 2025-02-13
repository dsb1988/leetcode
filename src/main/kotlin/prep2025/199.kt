package prep2025

import models.TreeNode

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left?.right = TreeNode(5)
    root.right?.right = TreeNode(4)
    println(rightSideView(root))
}

fun rightSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root == null) {
        return result
    }

    fun bfs(level: List<TreeNode>): List<TreeNode> {
        val nextLevel = mutableListOf<TreeNode>()
        val queue = mutableListOf<TreeNode>()
        queue.addAll(level)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node.left != null) {
                nextLevel.add(node.left!!)
            }
            if (node.right != null) {
                nextLevel.add(node.right!!)
            }
        }
        return nextLevel
    }

    result.add(root.`val`)
    var nextLevel = bfs(listOf(root))
    while (nextLevel.isNotEmpty()) {
        result.add(nextLevel.last().`val`)
        nextLevel = bfs(nextLevel)
    }

    return result
}