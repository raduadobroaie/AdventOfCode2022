import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_03(private val fileName: String) {
    private var totalPriority = 0
    private var totalBadgePriority = 0

    private var lineCounter = 0
    private var latestGroup:MutableList<List<Char>> = mutableListOf()

    fun execute() {
        val file = File(this.fileName)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::updatePriorities)}
    }

    fun getTotalPriority(): Int {
        return this.totalPriority
    }

    fun geTotalBadgePriority(): Int {
        return this.totalBadgePriority
    }

    private fun updatePriorities(line: String) {
        val chars = line.toList()

        updateBadgePriority(chars)
        updateTotalPriority(chars)
    }

    private fun updateBadgePriority(chars: List<Char>) {
        this.lineCounter++
        this.latestGroup.add(chars)

        if (this.lineCounter % 3 == 0) {
            val groupBadge = findBadge(this.latestGroup)
            this.totalBadgePriority += this.calculatePriority(groupBadge)
            this.latestGroup.clear()
        }
    }
    private fun findBadge(latestGroup: MutableList<List<Char>>): Char {
        return findDuplicates(
            findDuplicates(latestGroup[0],latestGroup[1]),
            latestGroup[2]
        ).first()
    }

    private fun updateTotalPriority(chars: List<Char>) {
        val lineSize = chars.size

        val firstHalf = chars.subList(0, lineSize / 2)
        val secondHalf = chars.subList(lineSize / 2, lineSize)
        val duplicate = this.findDuplicates(firstHalf, secondHalf).first()

        this.totalPriority += this.calculatePriority(duplicate)
    }


    private fun findDuplicates(firstHalf: List<Char>, secondHalf: List<Char>): List<Char> {
        return firstHalf.filter { secondHalf.contains(it) }
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
