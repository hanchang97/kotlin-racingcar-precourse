import controller.RaceController
import view.RaceView

fun main() {
    val raceController = RaceController(raceView = RaceView())

    initRacingCars(raceController = raceController)
    initRound(raceController = raceController)
    startGame(raceController = raceController)
    announceWinner(raceController = raceController)
}

private fun initRacingCars(raceController: RaceController) {
    raceController.printCarListInputMessage()
    raceController.inputAndValidateRacingCarNames()
}

private fun initRound(raceController: RaceController) {
    raceController.printRoundInputMesage()
    raceController.inputAndValidateRound()
}

private fun startGame(raceController: RaceController) {
    raceController.printStartGameMeesage()
    raceController.startGame()
}

private fun announceWinner(raceController: RaceController) {
    raceController.announceWinner()
}