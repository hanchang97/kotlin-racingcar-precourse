package view

class RaceView {
    companion object {
       private const val ERROR_TAG = "[ERROR]"
    }

    fun printCarListInputMesage() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRoundInputMesage() {
        println("시도할 횟수는 몇회인가요?")
    }

    fun printContent(message: String) {
        println(message)
    }

    fun printError(errorMessage: String) {
        println("$ERROR_TAG $errorMessage")
    }

    fun inputContent(): String = readLine() ?: ""
}