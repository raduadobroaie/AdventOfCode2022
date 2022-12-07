import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_01(private val fileName: String) {

    private val allTotals = mutableListOf<Int>()

    fun execute() {
        val file = File(fileName)

        var currentTotal = 0

        BufferedReader(FileReader(file)).use { br ->
            br.lines().forEach { line: String -> run {
                    print(line)
                    if (line.isBlank()) {
                        allTotals.add(currentTotal)
                        currentTotal = 0
                    } else {
                        currentTotal += line.toInt()
                    }
                }
            }
        }
    }

    fun maxTotal (): Int {
        return allTotals.max()
    }

    fun elfWithMaxTotal () : Int {
        return allTotals.indexOf(maxTotal())
    }
}