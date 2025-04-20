import controller.RaceController
import view.RaceView

fun main() {
    val raceView = RaceView()
    val raceController = RaceController(raceView = raceView)

    initGame(raceController = raceController)
}

private fun initGame(raceController: RaceController) {
    raceController.printCarListInputMessage()
    raceController.inputAndValidateRacingCarNames()
}