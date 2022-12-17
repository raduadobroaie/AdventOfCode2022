import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_01(private val fileName: String) {

    private val allTotals = mutableListOf<Int>()
    private var currentTotal = 0

    fun execute() {
        val file = File(this.fileName)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::solve) }

        allTotals.sortDescending()
    }

    private fun solve(line:String) {
        if (line.isBlank()) {
            this.allTotals.add(currentTotal)
            this.currentTotal = 0
        } else {
            this.currentTotal += line.toInt()
        }
    }

    fun getMaxTotal (): Int {
        return this.allTotals[0]
    }

    fun getTopThreeTotals () : List<Int> {
        return this.allTotals.subList(0,3)
    }
}