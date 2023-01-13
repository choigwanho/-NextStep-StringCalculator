import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    @DisplayName("더하기 테스트")
    public void add(){
        Calculator cal = new Calculator();
        assertEquals(12, cal.add(9,3));
    }
    @Test
    @DisplayName("빼기 테스트")
    public void subtract(){
        Calculator cal = new Calculator();
        assertEquals(6, cal.subtract(9,3));
    }
    @Test
    @DisplayName("곱하기 테스트")
    public void multiply(){
        Calculator cal = new Calculator();
        assertEquals(27, cal.multiply(9,3));
    }
    @Test
    @DisplayName("나누기 테스트")
    public void divide() {
        Calculator cal = new Calculator();
        assertEquals(3, cal.divide(9,3));
    }
}
