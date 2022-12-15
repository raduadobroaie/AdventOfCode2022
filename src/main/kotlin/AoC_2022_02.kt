import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_02 (private val fileName: String) {

    private var score = 0
    private var secondScore = 0
    private var roundCounter = 1

    fun execute() {
        val file = File(this.fileName)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::computeScores) }
    }

    fun getFinalScore(): Int {
        return this.score
    }

    fun getSecondScore(): Int {
        return this.secondScore
    }

    private fun computeScores(line: String) {
        val choices = line.split(' ')

        val firstChoice = FirstChoice.valueOf(choices[0])
        val secondChoice = SecondChoice.valueOf(choices[1])
        val roundState = RoundState.valueOf(choices[1])

        updateScore(firstChoice, secondChoice)
        updateSecondScore(firstChoice, roundState)
    }

    private fun updateScore(firstChoice: FirstChoice, secondChoice: SecondChoice) {
        this.score += secondChoice.getScore() + computeRoundOutcome(firstChoice, secondChoice).getScore()
    }

    private fun computeRoundOutcome(
        firstChoice: FirstChoice,
        secondChoice: SecondChoice
    ): RoundState {
        when (firstChoice) {
            FirstChoice.A -> {
                return when (secondChoice) {
                    SecondChoice.X -> {
                        RoundState.Z
                    }

                    SecondChoice.Y -> {
                        RoundState.X
                    }

                    SecondChoice.Z -> {
                        RoundState.Y
                    }
                }
            }

            FirstChoice.B -> {
                return when (secondChoice) {
                    SecondChoice.X -> {
                        RoundState.Y
                    }

                    SecondChoice.Y -> {
                        RoundState.Z
                    }

                    SecondChoice.Z -> {
                        RoundState.X
                    }
                }
            }

            FirstChoice.C -> {
                return when (secondChoice) {
                    SecondChoice.X -> {
                        RoundState.X
                    }

                    SecondChoice.Y -> {
                        RoundState.Y
                    }

                    SecondChoice.Z -> {
                        RoundState.Z
                    }
                }
            }
        }
    }

    private fun updateSecondScore(firstChoice: FirstChoice, outcome: RoundState) {
        this.secondScore += outcome.getScore() + reverseEngineerChoice(firstChoice, outcome).getScore()
        this.roundCounter++
    }

    private fun reverseEngineerChoice(
        firstChoice: FirstChoice,
        outcome: RoundState
    ): SecondChoice {
        when (firstChoice) {
            FirstChoice.A -> {
                return when (outcome) {
                    RoundState.X -> {
                        SecondChoice.Z
                    }

                    RoundState.Y -> {
                        SecondChoice.X
                    }

                    RoundState.Z -> {
                        SecondChoice.Y
                    }
                }
            }

            FirstChoice.B -> {
                return when (outcome) {
                    RoundState.X -> {
                        SecondChoice.X
                    }

                    RoundState.Y -> {
                        SecondChoice.Y
                    }

                    RoundState.Z -> {
                        SecondChoice.Z
                    }
                }
            }
            FirstChoice.C -> {
                return when (outcome) {
                    RoundState.X -> {
                        SecondChoice.Y
                    }

                    RoundState.Y -> {
                        SecondChoice.Z
                    }

                    RoundState.Z -> {
                        SecondChoice.X
                    }
                }
            }
        }
    }

    // TODO: Update enums with printable names
    enum class RoundState : IChoiceScore {
        // Loss
        X {
            override fun getScore() = 0
        },
        // Draw
        Y {
            override fun getScore() = 3
        },
        // Win
        Z {
            override fun getScore() = 6
        }
    }

    enum class FirstChoice : IChoiceScore {
        // Rock
        A {
            override fun getScore() = 1
        },
        // Paper
        B {
            override fun getScore() = 2
        },
        // Scissors
        C {
            override fun getScore() = 3
        }
    }

    enum class SecondChoice : IChoiceScore {
        // Rock
        X {
            override fun getScore() = 1
        },
        // Paper
        Y {
            override fun getScore() = 2
        },
        // Scissors
        Z {
            override fun getScore() = 3
        }
    }

    interface IChoiceScore {
        fun getScore(): Int
    }
}
