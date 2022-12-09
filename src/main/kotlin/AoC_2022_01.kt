import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_01(private val fileName: String) {

    private val allTotals = mutableListOf<Int>()
    private var currentTotal = 0

    fun execute() {
        val file = File(fileName)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::computeCurrentTotal) }
    }

    private fun computeCurrentTotal(line:String) {
        if (line.isBlank()) {
            this.allTotals.add(currentTotal)
            this.currentTotal = 0
        } else {
            this.currentTotal += line.toInt()
        }
    }

    fun maxTotal (): Int {
        return allTotals.max()
    }

    fun elfWithMaxTotal () : Int {
        return allTotals.indexOf(maxTotal())
    }
}