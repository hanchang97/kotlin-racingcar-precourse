import controller.RaceController
import view.RaceView

fun main() {
    val raceController = RaceController(raceView = RaceView())

    initRacingCars(raceController = raceController)
    initRound(raceController = raceController)
}

private fun initRacingCars(raceController: RaceController) {
    raceController.printCarListInputMessage()
    raceController.inputAndValidateRacingCarNames()
}

private fun initRound(raceController: RaceController) {
    raceController.printRoundInputMesage()
    raceController.inputAndValidateRound()
}