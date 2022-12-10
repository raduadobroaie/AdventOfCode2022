import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class AoC_2022_02 (private val input: String) {

    private var score = 0

    fun execute() {
        val file = File(input)

        BufferedReader(FileReader(file)).use { br -> br.lines().forEach(::computeScore) }
    }

    fun getFinalScore(): Int {
        return this.score
    }

    private fun computeScore(line: String) {
        val choices = line.split(' ')

        val firstChoice = FirstChoice.valueOf(choices[0])
        val secondChoice = SecondChoice.valueOf(choices[1])

        updateScore(firstChoice, secondChoice)
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
                        RoundState.DRAW
                    }

                    SecondChoice.Y -> {
                        RoundState.WIN
                    }

                    SecondChoice.Z -> {
                        RoundState.LOSS
                    }
                }
            }

            FirstChoice.B -> {
                return when (secondChoice) {
                    SecondChoice.X -> {
                        RoundState.LOSS
                    }

                    SecondChoice.Y -> {
                        RoundState.DRAW
                    }

                    SecondChoice.Z -> {
                        RoundState.WIN
                    }
                }
            }
            FirstChoice.C -> {
                return when (secondChoice) {
                    SecondChoice.X -> {
                        RoundState.WIN
                    }

                    SecondChoice.Y -> {
                        RoundState.LOSS
                    }

                    SecondChoice.Z -> {
                        RoundState.DRAW
                    }
                }
            }
        }
    }

    enum class RoundState : IChoiceScore {
        WIN {
            override fun getScore() = 6
        },
        LOSS {
            override fun getScore() = 0
        },
        DRAW {
            override fun getScore() = 3
        }
    }

    enum class FirstChoice : IChoiceScore {
        A {
            override fun getScore() = 1
        },
        B {
            override fun getScore() = 2
        },
        C {
            override fun getScore() = 3
        }
    }

    enum class SecondChoice : IChoiceScore {
        X {
            override fun getScore() = 1
        },
        Y {
            override fun getScore() = 2
        },
        Z {
            override fun getScore() = 3
        }
    }

    interface IChoiceScore {
        fun getScore(): Int
    }
}
