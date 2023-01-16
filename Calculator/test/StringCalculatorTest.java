import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator scal;

    @BeforeEach
    public void setup(){
        scal = new StringCalculator();
    }
    // 테스트를 할때 기능당 메소드를 생성해야한다.
//    @Test
//    void add() {
//        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//            assertEquals(6, scal.add("1,2:3"));
//            assertEquals(6, scal.add("1,2,3"));
//            assertEquals(6, scal.add("//;\n1;2;3"));
//            assertEquals(3, scal.add("3"));
//            assertEquals(0, scal.add(""));
            //assertEquals(0,scal.add(null)); // 왜 nullpoint에러가 나지?
            // 런타임에러 예외처리가 발생해서 테스트가 정상적으로 통과하는가
//            scal.add("-1,2,3");
//        });
//    }

    @Test
    void add_숫자하나(){
        assertEquals(3, scal.add("3"));
    }
    @Test
    void add_쉼표콜론(){
        assertEquals(6, scal.add("1,2:3"));
    }
    @Test
    void add_음수(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            scal.add("-1,2,3");
        });
    }
}