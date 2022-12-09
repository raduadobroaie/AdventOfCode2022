import junit.framework.TestCase.assertEquals
import org.junit.Test

class AoC_2022_01_Test {

    @Test
    fun givenTestData_whenExecute_thenCorrectMaxReturned() {
        val testFile = "src/test/kotlin/data/testData1"
        val expected = 24000
        val solution = AoC_2022_01(testFile)

        solution.execute()
        val max = solution.maxTotal()

        assertEquals(expected, max)
    }
}