import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator cal;
    @BeforeEach // 각각의 테스트 메소드가 실행되기 전에 메소드를 실행
    public void setup(){
        cal = new Calculator();
    }
    @Test
    @DisplayName("더하기 테스트")
    public void add(){
        assertThat(cal.add(9,3)).isEqualTo(12);
    }
    @Test
    @DisplayName("빼기 테스트")
    public void subtract(){
        assertThat(cal.subtract(9,3)).isEqualTo(6);
    }
    @Test
    @DisplayName("곱하기 테스트")
    public void multiply(){
        assertThat(cal.multiply(9,3)).isEqualTo(27);
    }
    @Test
    @DisplayName("나누기 테스트")
    public void divide() {
        assertThat(cal.divide(9,3)).isEqualTo(3);
    }
}
