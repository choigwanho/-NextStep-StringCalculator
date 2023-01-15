package nextstep.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("1,2,3 을 전달하는 경우, 6을 출력")
    void getNumbers() {
        int number = calculator.calculate("1,2,3");

        assertThat(number).isEqualTo(6);
    }

    @Test
    @DisplayName("\"1,2,3,4,5,6\"을 전달하는 경우, 21을 출력")
    void getNumbers2() {
        int result = calculator.calculate("1,2,3,4,5,6");

        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("\"1;2;3\"을 전달하는 경우, 6을 출력")
    void getNumbers3() {
        int result = calculator.calculate("1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("1;2;3;4;5;6 을 전달하는 경우, 21을 출력")
    void getNumbers4() {
        int result = calculator.calculate("1;2;3;4;5;6");

        assertThat(result).isEqualTo(21);
    }

    @Test
    @DisplayName("1,2;3 을 전달하는 경우, 에러 발생")
    void containsMultipleSeparator() {
        assertThrows(NumberFormatException.class, () -> calculator.calculate("1,2;3"));
    }

    @Test
    @DisplayName("1,2,a 을 전달하는 경우, 에러 발생")
    void containsLetter() {
        assertThrows(NumberFormatException.class, () -> calculator.calculate("1,2,a"));
    }

    @Test
    @DisplayName("1,2,-3 을 전달하는 경우, 에러 발생")
    void containsNegetiveNumber() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("1,2,-3"));
    }
}