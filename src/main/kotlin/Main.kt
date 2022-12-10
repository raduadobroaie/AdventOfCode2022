fun main() {
    println("Problem 1")
    val solution1 = solution1()

    println("Part 1")
    println("Max total: " + solution1.getMaxTotal())

    println("Part 2")
    val topThreeTotals = solution1.getTopThreeTotals()
    println("Top three: $topThreeTotals")
    println("Top three total calories: " + topThreeTotals.sum())
    println()

    println("Problem 2")
    val solution2 = solution2()
    println("Final score: " + solution2.getFinalScore())
    println()
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