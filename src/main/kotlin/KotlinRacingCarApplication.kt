import controller.RaceController
import view.RaceView

fun main() {
    val raceView = RaceView()
    val raceController = RaceController()

    initGame(
        raceView = raceView,
        raceController = raceController
    )
}

private fun initGame(raceView: RaceView, raceController: RaceController) {
    raceView.printCarListInputMesage()
    raceController.isValidateRacingCarNames(raceView.inputContent())
}