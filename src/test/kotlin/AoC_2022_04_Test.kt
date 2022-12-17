import junit.framework.TestCase
import org.junit.Test

class AoC_2022_04_Test {
    private val testFile = "src/test/kotlin/data/testData4"
    private val solution = AoC_2022_04(testFile)

    private fun setup() {
        this.solution.execute()
    }
    @Test
    fun givenTestData_whenExecute_thenCorrectTotalRedundantPairsReturned() {
        setup()

        val expected = 2
        val priority = this.solution.getRedundantPairs()

        TestCase.assertEquals(expected, priority)
    }

    @Test
    fun givenTestData_whenExecute_thenCorrectTotalOverlapsReturned() {
        setup()

        val expected = 4
        val priority = this.solution.getTotalOverlaps()

        TestCase.assertEquals(expected, priority)
    }
}