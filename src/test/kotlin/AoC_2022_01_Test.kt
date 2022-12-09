import junit.framework.TestCase.assertEquals
import org.junit.Test

class AoC_2022_01_Test {
    private val testFile = "src/test/kotlin/data/testData1"
    private val solution = AoC_2022_01(testFile)

    fun setup() {
        this.solution.execute()
    }

    @Test
    fun givenTestData_whenExecute_thenCorrectMaxReturned() {
        this.setup()

        val expected = 24000

        val max = this.solution.getMaxTotal()

        assertEquals(expected, max)
    }

    @Test
    fun givenTestData_whenExecute_thenCorrectTopThreeReturned() {
        setup()

        val expected = listOf(24000, 24000, 16000)

        solution.execute()
        val topThree = solution.getTopThreeTotals()

        assertEquals(expected.size, topThree.size)
        assert(expected == topThree)
    }
}