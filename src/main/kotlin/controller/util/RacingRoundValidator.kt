package controller.util

object RacingRoundValidator {
    fun validateAndReturnRound(inputRound: String): Int {
        return try {
            val round = inputRound.toInt()

            if (round <= 0) throw IllegalStateException("시도할 횟수는 1 이상이어야 합니다.")

            round
        } catch (exception: NumberFormatException) {
            throw NumberFormatException("시도할 횟수에 숫자가 아닌 값이 입력되었습니다.")
        }
    }
}