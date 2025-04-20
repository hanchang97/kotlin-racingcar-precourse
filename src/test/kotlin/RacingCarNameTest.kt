import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import util.RacingCarNameValidator

class RacingCarNameTest {
    @Test
    @DisplayName("5자 초과하는 경주용 차량 이름이 포함된 경우 에러 반환")
    fun givenMoreThan5CharacterInput_thenThrowsExeption() {
        val racingCarNames = "123456,12345"

        assertThrows(IllegalStateException::class.java) {
            RacingCarNameValidator.isValidateRacingCarName(racingCarNames)
        }
    }

    @Test
    @DisplayName("빈 문자열 형태의 경주용 차량 이름이 포함된 경우 에러 반환")
    fun givenEmptyInput_thenThrowsExeption() {
        val racingCarNames = ",12345"

        assertThrows(IllegalStateException::class.java) {
            RacingCarNameValidator.isValidateRacingCarName(racingCarNames)
        }
    }

    @Test
    @DisplayName("공백만 존재하는 형태의 경주용 차량 이름이 포함된 경우 에러 반환")
    fun givenOnlySpacesInput_thenThrowsExeption() {
        val racingCarNames = "      ,12345"

        assertThrows(IllegalStateException::class.java) {
            RacingCarNameValidator.isValidateRacingCarName(racingCarNames)
        }
    }
}