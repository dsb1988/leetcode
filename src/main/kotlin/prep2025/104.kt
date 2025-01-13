package prep2025

import models.TreeNode
import kotlin.math.max

// dfs
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left == null && root.right == null) return 1


    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}