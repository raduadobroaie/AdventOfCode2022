fun main() {
    aocProblem1()
    aocProblem2()
}

fun aocProblem1 () {
    println("Problem 1")
    val solution1 = AoC_2022_01("src/main/kotlin/data/inputFile1")

    println("Part 1")
    println("Max total: " + solution1.getMaxTotal())

    println("Part 2")
    val topThreeTotals = solution1.getTopThreeTotals()
    println("Top three: $topThreeTotals")
    println("Top three total calories: " + topThreeTotals.sum())
    println()
}
fun aocProblem2 () {
    println("Problem 2")
    val solution2 = AoC_2022_02("src/main/kotlin/data/inputFile2")

    println("Part 1")
    println("Final score: " + solution2.getFinalScore())
    println("Part 2")
    println("Second score: " + solution2.getSecondScore())
    println()
}