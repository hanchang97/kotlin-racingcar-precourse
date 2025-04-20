package controller

import model.RacingCar
import model.Round
import controller.util.RacingCarMapper
import controller.util.RacingCarNameValidator
import controller.util.RacingRoundValidator
import controller.util.RandomNumberGenerator
import view.RaceView

class RaceController(
    val raceView: RaceView
) {
    var racingCars = mutableListOf<RacingCar>()
    var round = Round()

    fun printCarListInputMessage() {
        raceView.printContent("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRoundInputMesage() {
        raceView.printContent("시도할 횟수는 몇회인가요?")
    }

    fun printStartGameMeesage() {
        raceView.printContent("실행 결과")
    }

    fun printRacingCarStatus(racingCar: RacingCar) {
        raceView.printContent("${racingCar.name} : ${racingCar.getPositionStateString()}")
    }

    fun printEnter() {
        raceView.printContent("")
    }

    fun inputAndValidateRacingCarNames() {
        var isValidationPassed = false

        while (isValidationPassed.not()) {
            try {
                raceView.inputContent().also { inputRacingCarNames ->
                    isValidationPassed = RacingCarNameValidator.isValidateRacingCarName(inputRacingCarNames)
                    racingCars = RacingCarMapper.mapToRacingCars(inputRacingCarNames).toMutableList()
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

    fun startGame() {
        while (round.totalRound > 0) {
            racingCars.forEachIndexed { index, racingCar ->
                racingCars[index] = racingCar.copy(position = racingCar.position + if (RandomNumberGenerator.generateRandomNumber() >= 4) 1 else 0)
                printRacingCarStatus(racingCar)
            }

            round = round.copy(totalRound = round.totalRound - 1)
            printEnter()
        }
    }

    fun announceWinner() {
        
    }
}