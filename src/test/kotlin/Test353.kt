import org.junit.jupiter.api.Test
import prep2023.SnakeGame
import kotlin.test.assertEquals

class Test353 {

    @Test
    fun test1() {
        val game = SnakeGame(3, 2, arrayOf(intArrayOf(1,2), intArrayOf(0, 1)))
        val input = listOf("R", "D", "R", "U", "L", "U")
        assertEquals(0, game.move(input[0]))
        assertEquals(0, game.move(input[1]))
        assertEquals(1, game.move(input[2]))
        assertEquals(1, game.move(input[3]))
        assertEquals(2, game.move(input[4]))
        assertEquals(-1, game.move(input[5]))
    }
}