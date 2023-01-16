import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReStringCalculatorTest {

    private ReStringCalculator rcal;

    @BeforeEach
    public void setup(){
        rcal = new ReStringCalculator();
    }
    @Test
    void add_쉼표_또는_콜론_구분자() {
        assertEquals(6, rcal.add("1,2:3"));
    }

    @Test
    void add_커스텀_구분자() {
        assertEquals(6, rcal.add("//;\n1;2;3"));
    }

    @Test
    void add_음수(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            rcal.add("-1,2,3");
        });
    }
}