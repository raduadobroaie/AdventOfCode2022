import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_04(private val fileName: String) {
    /**
     * TODO: Turns out I'm still thinking in OOP terms here. In FP functions should never have side effects like this
     */
    private var redundantPairs = 0
    private var totalOverlaps = 0

    fun execute() {
        val file = File(this.fileName)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::solve)}
    }

    fun getRedundantPairs(): Int {
        return this.redundantPairs
    }

    fun getTotalOverlaps(): Int {
        return this.totalOverlaps
    }

    private fun solve(line: String) {
        val pairs = parseLine(line)

        findRedundancies(pairs)
        findOverlaps(pairs)
    }

    private fun parseLine(line: String) = line.split(',').flatMap {
        it.split('-')
    }.map { it.toInt() }

    private fun findRedundancies(pairs: List<Int>) {
        if (pairs[0] >= pairs[2] && pairs[1] <= pairs[3] ||
            pairs[2] >= pairs[0] && pairs[3] <= pairs[1]) {
            this.redundantPairs++
        }
    }

    private fun findOverlaps(pairs: List<Int>) {
        if (pairs[0] in pairs[2]..pairs[3] ||
            pairs[1] in pairs[2]..pairs[3] ||
            pairs[2] in pairs[0]..pairs[1] ||
            pairs[3] in pairs[0]..pairs[1]) {
            this.totalOverlaps++
        }
    }
}
