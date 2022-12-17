fun main() {
    aocProblem1()
    aocProblem2()
    aocProblem3()
}

fun aocProblem1 () {
    println("Problem 1")
    val solution = AoC_2022_01("src/main/kotlin/data/inputFile1")
    solution.execute()

    println("Part 1")
    println("Max total: " + solution.getMaxTotal())

    println("Part 2")
    val topThreeTotals = solution.getTopThreeTotals()
    println("Top three: $topThreeTotals")
    println("Top three total calories: " + topThreeTotals.sum())
    println()
}
fun aocProblem2 () {
    println("Problem 2")
    val solution = AoC_2022_02("src/main/kotlin/data/inputFile2")
    solution.execute()

    println("Part 1")
    println("Final score: " + solution.getFinalScore())
    println("Part 2")
    println("Second score: " + solution.getSecondScore())
    println()
}
fun aocProblem3 () {
    println("Problem 3")
    val solution = AoC_2022_03("src/main/kotlin/data/inputFile3")
    solution.execute()

    println("Part 1")
    println("Total priority: " + solution.getTotalPriority())
    println("Part 2")
    println("Total badge priority: " + solution.geTotalBadgePriority())
    println()
}