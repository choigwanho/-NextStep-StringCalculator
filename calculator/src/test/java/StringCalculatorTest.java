import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringCalculatorTest {

    StringCalculator strCal;

    @BeforeEach
    public void setup(){
        strCal = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 또는 null 값 입력시 0 반환")
    public void add_null_또는_빈문자(){
        assertThat(strCal.add(null)).isEqualTo(0);
        assertThat(strCal.add("")).isEqualTo(0);
    }
    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    public void add_숫자하나(){
        assertThat(strCal.add("1")).isEqualTo(1);
    }
    @Test
    @DisplayName("쉼표 구분자를 사용해 숫자 두개 이상 입력할 경우 숫자의 합을 반환")
    public void add_쉼표구분자(){
        assertThat(strCal.add("1,2")).isEqualTo(3);
        assertThat(strCal.add("1,2,3")).isEqualTo(6);
    }
    @Test
    @DisplayName("쉼표 이외에 콜론 구분자를 사용해 숫자 두개 이상 입력할 경우 숫자의 합을 반환")
    public void add_쉼표_또는_콜론_구분자(){
        assertThat(strCal.add("1,2:3")).isEqualTo(6);
    }
    @Test
    @DisplayName("커스텀 구분자를 사용해 숫자 두개 이상 입력할 경우 숫자의 합을 반환")
    public void add_커스텀_구분자(){
        assertThat(strCal.add("//;\n1;2;3")).isEqualTo(6);
    }
    @Test
    @DisplayName("음수를 전달하는 경우 RuntimeException 예외 처리")
    public void add_음수_예외_처리(){
        assertThrows(RuntimeException.class, () -> {
            strCal.add("1,-1,3");
        }, "음수가 없습니다.");
    }
}
