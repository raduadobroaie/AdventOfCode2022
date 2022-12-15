import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_03(private val fileName: String) {
    private var totalPriority = 0

    fun execute() {
        val file = File(this.fileName)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::updateTotalPriority) }
    }

    fun getTotalPriority(): Int {
        return this.totalPriority
    }

    private fun updateTotalPriority(line: String) {
        val chars = line.toList()
        val duplicate = this.findDuplicates(chars).first()

        this.totalPriority += this.calculatePriority(duplicate)
    }

    private fun findDuplicates(chars:List<Char>): CharArray {
        val lineSize = chars.size

        return chars.subList(0, lineSize/2).filter {
            chars.subList(lineSize/2, lineSize).contains(it)
        }.toCharArray()
    }

    private fun calculatePriority(item: Char): Int {
        // TODO: Fix magic numbers
        val priority = when {
            item.isLowerCase() -> {
                item.code - 96
            }
            else -> {
                item.code - 38
            }
        }

        return  priority
    }
}
