package prep2025

import models.TreeNode

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return null
    if (p == null) return null
    if (q == null) return null

    val pVal = p.`val`
    val qVal = q.`val`
    val curVal = root.`val`

    return if (pVal > curVal && qVal > curVal) {
        lowestCommonAncestor(root.right, p, q)
    } else if (pVal > curVal && qVal < curVal) {
        lowestCommonAncestor(root.left, p, q)
    } else {
        root
    }
}