import junit.framework.TestCase
import org.junit.Test

class AoC_2022_02_Test {
    private val testFile = "src/test/kotlin/data/testData2"
    private val solution = AoC_2022_02(testFile)

    fun setup() {
        this.solution.execute()
    }
    @Test
    fun givenTestData_whenExecute_thenCorrectScoreReturned() {
        setup()

        val expected = 15
        val score = this.solution.getFinalScore()

        TestCase.assertEquals(expected, score)
    }

    @Test
    fun givenTestData_whenExecute_thenCorrectSecondScoreReturned() {
        setup()

        val expected = 15
        val score = this.solution.getSecondScore()

        TestCase.assertEquals(expected, score)
    }
}