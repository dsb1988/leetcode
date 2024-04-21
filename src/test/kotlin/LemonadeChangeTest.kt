import org.junit.jupiter.api.Test
import prep2023.lemonadeChange
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LemonadeChangeTest {

    @Test
    fun testOne() {
        val bills = intArrayOf(5,5,5,10,20)
        assertTrue(lemonadeChange(bills))
    }

    @Test
    fun testTwo() {
        val bills = intArrayOf(5,5,10,10,20)
        assertFalse(lemonadeChange(bills))
    }

}