import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator cal;

    @BeforeEach
    public void setup(){
        cal = new Calculator();
        System.out.println("before");
    }
    @org.junit.jupiter.api.Test
    void add() {
//        System.out.println(cal.add(6,3));
        assertEquals(9, cal.add(6, 3));
    }

    @Test
    void subtract() {
//        System.out.println(cal.subtract(6,3));
        assertEquals(3, cal.subtract(7, 3));
    }

    @Test
    void multiply() {
        System.out.println(cal.multiply(6, 3));
    }

    @Test
    void divide() {
        System.out.println(cal.divide(6, 3));
    }

    @AfterEach
    public void teardown(){
        System.out.println("teardown");
    }
}