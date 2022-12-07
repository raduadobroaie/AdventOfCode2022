fun main() {
    val solution1 = solution1()

    println("Max total: " + solution1.maxTotal())
    println("Elf with max total: " + solution1.elfWithMaxTotal())
}

fun solution1 (): AoC_2022_01 {
    val solution = AoC_2022_01("src/main/kotlin/data/inputFile1")

    solution.execute()

    return solution
}