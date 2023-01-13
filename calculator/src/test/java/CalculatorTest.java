import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("더하기 테스트")
    public void add(){
        Calculator cal = new Calculator();
        assertThat(cal.add(9,3)).isEqualTo(12);
    }
    @Test
    @DisplayName("빼기 테스트")
    public void subtract(){
        Calculator cal = new Calculator();
        assertThat(cal.subtract(9,3)).isEqualTo(6);
    }
    @Test
    @DisplayName("곱하기 테스트")
    public void multiply(){
        Calculator cal = new Calculator();
        assertThat(cal.multiply(9,3)).isEqualTo(27);
    }
    @Test
    @DisplayName("나누기 테스트")
    public void divide() {
        Calculator cal = new Calculator();
        assertThat(cal.divide(9,3)).isEqualTo(3);
    }
}
