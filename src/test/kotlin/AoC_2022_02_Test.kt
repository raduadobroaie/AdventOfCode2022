import junit.framework.TestCase
import org.junit.Test

class AoC_2022_02_Test {

    @Test
    fun givenTestData_whenExecute_thenCorrectScoreReturned() {
        val testFile = "src/test/kotlin/data/testData2"
        val expected = 15
        val solution = AoC_2022_02(testFile)

        solution.execute()
        val score = solution.getFinalScore()

        TestCase.assertEquals(expected, score)
    }
}