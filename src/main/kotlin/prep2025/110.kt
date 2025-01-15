package prep2025

import models.TreeNode
import kotlin.math.abs
import kotlin.math.max

fun isBalanced(root: TreeNode?): Boolean {
    var result = true

    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val left = dfs(root.left)
        val right = dfs(root.right)

        if (abs(left - right) > 1) {
            result = false
        }

        return max(left, right) + 1
    }

    dfs(root)

    return result
}