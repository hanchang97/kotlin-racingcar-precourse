import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import controller.util.RacingRoundValidator

class RacingRoundTest {
    @Test
    @DisplayName("시도 횟수 입력 시 숫자가 아닌 형태 포함된 경우 에러 반환")
    fun givenNonNumberInput_thenThrowsExeption() {
        val round = "1,,"

        assertThrows(NumberFormatException::class.java) {
            RacingRoundValidator.validateAndReturnRound(round)
        }
    }

    @Test
    @DisplayName("시도 횟수 입력 시 0 이하 입력된 경우 에러 반환")
    fun givenUnderZeroInput_thenThrowsExeption() {
        //val round = "0"
        val round = "-1"

        assertThrows(IllegalStateException::class.java) {
            RacingRoundValidator.validateAndReturnRound(round)
        }
    }
}