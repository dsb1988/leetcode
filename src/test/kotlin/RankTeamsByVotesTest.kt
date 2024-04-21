import org.junit.jupiter.api.Test
import prep2023.rankTeams
import kotlin.test.assertEquals

class RankTeamsByVotesTest {
    @Test
    fun testOne() {
        val votes = arrayOf("ABC","ACB","ABC","ACB","ACB")
        val expected = "ACB"
        assertEquals(expected, rankTeams(votes))
    }

    @Test
    fun testTwo() {
        val votes = arrayOf("WXYZ","XYZW")
        val expected = "XWYZ"
        assertEquals(expected, rankTeams(votes))
    }

    @Test
    fun testThree() {
        val votes = arrayOf("BCA","CAB","CBA","ABC","ACB","BAC")
        val expected = "ABC"
        assertEquals(expected, rankTeams(votes))
    }
}