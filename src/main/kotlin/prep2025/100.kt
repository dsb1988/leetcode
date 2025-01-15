package prep2025

import models.TreeNode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null) return false
    if (q == null) return false

    return if (p.`val` == q.`val`) {
        isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    } else {
        false
    }
}