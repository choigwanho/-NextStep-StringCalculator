import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    /* TASK
        - 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환
        - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
        - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있음
          - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치한 문자를 커스텀 구분자로 사용
        - 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리
    */
    public int add(String text){

        if (isBlank(text)) return 0;

        return sum(toInts(split(text)));

    }
    private boolean isBlank(String text){
        return text == null || text.isEmpty();
    }
    private String[] split(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }
    private int[] toInts(String[] values){
        int[] nums = new int[values.length];
        for (int i = 0; i < values.length; i++)
            nums[i] = toPositive(values[i]);
        return nums;
    }
    private int toPositive(String value){
        int num = Integer.parseInt(value);
        if (num < 0) throw new RuntimeException("음수가 입력됐습니다.");
        return num;
    }
    private int sum(int[] nums){
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }
}
