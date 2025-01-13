package prep2025

import models.TreeNode

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    if (root.left == null && root.right == null) return root

    val leftLeaf = root.left
    val rightLeaf = root.right
    root.left = invertTree(rightLeaf)
    root.right = invertTree(leftLeaf)
    return root
}