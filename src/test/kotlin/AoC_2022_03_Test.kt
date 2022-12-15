import junit.framework.TestCase
import org.junit.Test

class AoC_2022_03_Test {
    private val testFile = "src/test/kotlin/data/testData3"
    private val solution = AoC_2022_03(testFile)

    fun setup() {
        this.solution.execute()
    }
    @Test
    fun givenTestData_whenExecute_thenCorrectTotalPriorityReturned() {
        setup()

        val expected = 157
        val priority = this.solution.getTotalPriority()

        TestCase.assertEquals(expected, priority)
    }
}