package prep2025

import models.TreeNode

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    println(levelOrder(root))
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    fun bfs(level: List<TreeNode>): List<TreeNode> {
        if (level.isEmpty()) return emptyList()
        val queue = mutableListOf<TreeNode>()
        queue.addAll(level)
        val nextLevel = mutableListOf<TreeNode>()
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


    val result = mutableListOf<List<Int>>()
    result.add(listOf(root.`val`))

    var level = bfs(listOf(root))
    while (level.isNotEmpty()) {
        result.add(level.map { it.`val` })
        level = bfs(level)
    }
    return result
}