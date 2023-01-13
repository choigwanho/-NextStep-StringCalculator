import org.junit.jupiter.api.BeforeEach;
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
    public void add_null_또는_빈문자(){
        assertThat(strCal.add(null)).isEqualTo(0);
        assertThat(strCal.add(" ")).isEqualTo(0);
    }
    @Test
    public void add_한문자(){
        assertThat(strCal.add("1")).isEqualTo(1);
    }
    @Test
    public void add_쉼표_구분자(){
        assertThat(strCal.add("1,2")).isEqualTo(3);
        assertThat(strCal.add("1,2,3")).isEqualTo(6);
    }
    @Test
    public void add_쉼표_또는_콜론_구분자(){
        assertThat(strCal.add("1,2:3")).isEqualTo(6);
    }
    @Test
    public void add_커스텀_구분자(){
        assertThat(strCal.add("//;\n1;2;3")).isEqualTo(6);
    }
    @Test
    public void add_음수_예외_처리(){
        assertThrows(RuntimeException.class, () -> {
            strCal.add("1,-1,3");
        }, "음수가 없습니다.");
    }
}
