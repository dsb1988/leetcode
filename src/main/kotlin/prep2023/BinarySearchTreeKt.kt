package prep2023

fun main() {

}

class Node(newData: Int) {
    var left: Node? = null
    var right: Node? = null
    var data: Int = newData
}

private fun isPresent(root: Node, value: Int): Int {
    return if (value == root.data) {
        1
    } else if (value > root.data && root.right != null) {
        isPresent(root.right!!, value)
    } else if (value < root.data && root.left != null) {
        isPresent(root.left!!, value)
    } else {
        0
    }
}