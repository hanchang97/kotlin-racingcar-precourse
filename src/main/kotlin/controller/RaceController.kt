package controller

import model.RacingCar
import model.Round
import util.RacingCarMapper
import util.RacingCarNameValidator
import util.RacingRoundValidator
import view.RaceView

class RaceController(
    val raceView: RaceView
) {
    var racingCars = emptyList<RacingCar>()
    var round = Round()

    fun printCarListInputMessage() {
        raceView.printContent("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRoundInputMesage() {
        raceView.printContent("시도할 횟수는 몇회인가요?")
    }

    fun inputAndValidateRacingCarNames() {
        var isValidationPassed = false

        while (isValidationPassed.not()) {
            try {
                raceView.inputContent().also { inputRacingCarNames ->
                    isValidationPassed = RacingCarNameValidator.isValidateRacingCarName(inputRacingCarNames)
                    racingCars = RacingCarMapper.mapToRacingCars(inputRacingCarNames)
                }
            } catch (exception: IllegalStateException) {
                raceView.printError(exception.message ?: "Error!")
            }
        }
    }

    fun inputAndValidateRound() {
        while (round.totalRound <= 0) {
            try {
                round = round.copy(totalRound = RacingRoundValidator.validateAndReturnRound(raceView.inputContent()))
            } catch (exception: Exception) {
                raceView.printError(exception.message ?: "Error!")
            }
        }
    }
}