package prep2025

import models.TreeNode

fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false

        return if (p.`val` != q.`val`) {
            false
        } else {
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
    }

    if (subRoot == null) return true
    if (root == null) return false
    if (isSameTree(root, subRoot)) return true

    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
}