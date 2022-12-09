fun main() {
    val solution1 = solution1()

    // Part 1
    println("Max total: " + solution1.getMaxTotal())
    println("Elf with max total: " + solution1.getElfWithMaxTotal())

    // Part 2
    val topThreeTotals = solution1.getTopThreeTotals()
    println("Top three: $topThreeTotals")
    println("Top three total calories: " + topThreeTotals.sum())
}

fun solution1 (): AoC_2022_01 {
    val solution = AoC_2022_01("src/main/kotlin/data/inputFile1")

    solution.execute()

    return solution
}
fun solution2 (): AoC_2022_02 {
    val solution = AoC_2022_02("src/main/kotlin/data/inputFile2")

    solution.execute()

    return solution
}