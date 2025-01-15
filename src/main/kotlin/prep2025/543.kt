package prep2025

import models.TreeNode
import kotlin.math.max

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var result = 0

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        val left = maxDepth(root.left)
        val right = maxDepth(root.right)

        result = max(result, left + right)

        return max(left, right) + 1
    }

    maxDepth(root)

    return result
}

