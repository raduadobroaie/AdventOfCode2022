import junit.framework.TestCase
import org.junit.Test

class AoC_2022_03_Test {
    private val testFile = "src/test/kotlin/data/testData3"
    private val solution = AoC_2022_03(testFile)

    private fun setup() {
        this.solution.execute()
    }
    @Test
    fun givenTestData_whenExecute_thenCorrectTotalPriorityReturned() {
        setup()

        val expected = 157
        val priority = this.solution.getTotalPriority()

        TestCase.assertEquals(expected, priority)
    }

    @Test
    fun givenTestData_whenExecute_thenCorrectTotalBadgePriorityReturned() {
        setup()

        val expected = 70
        val priority = this.solution.geTotalBadgePriority()

        TestCase.assertEquals(expected, priority)
    }
}