import java.util.LinkedList

class SnakeGame(private val width: Int, private val height: Int, food: Array<IntArray>) {
    private val snake = LinkedList<Point>()
    private var foodIndex = 0
    private val food = mutableListOf<Point>()

    init {
        snake.add(Point(0,0))
        food.forEach { pos ->
            this.food.add(Point(pos[1], pos[0]))
        }
        println("Food: " + this.food)
    }

    fun move(direction: String): Int {
        val head = snake.first()
        val newHead = when (direction) {
            "U" -> Point(head.x, head.y-1)
            "D" -> Point(head.x, head.y+1)
            "L" -> Point(head.x-1, head.y)
            "R" -> Point(head.x+1, head.y)
            else -> head
        }

        if (newHead.offTheBoard()) return -1
        if (newHead.hitsTheBody()) return -1
        return if (newHead.hitsFood()) {
            snake.offerFirst(newHead)
            foodIndex++
            foodIndex
        } else {
            snake.offerFirst(newHead)
            snake.removeLast()
            foodIndex
        }
    }

    data class Point(val x: Int, val y: Int)

    private fun Point.offTheBoard() = x < 0 || x >= width || y < 0 || y >= height
    private fun Point.hitsTheBody(): Boolean {
        val bodyNoTail = snake.slice(1 until snake.size-1)
        return bodyNoTail.contains(this)
    }
    private fun Point.hitsFood(): Boolean {
        return if (foodIndex < food.size) {
            food[foodIndex] == this
        } else {
            false
        }
    }
}