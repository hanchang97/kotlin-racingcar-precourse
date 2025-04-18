import controller.RaceController
import view.RaceView

fun main() {
    val raceView = RaceView()
    val raceController = RaceController()

    initGame(raceView)
}

private fun initGame(raceView: RaceView) {
    raceView.printCarListInputMesage()
}