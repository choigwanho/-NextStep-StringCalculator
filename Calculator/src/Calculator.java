import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    int add(int i, int j ){
        return i+j;
    }
    int subtract(int i, int j ){
        return i-j;
    }
    int multiply(int i, int j ){
        return i*j;
    }
    int divide(int i, int j ){
        return i/j;
    }

    String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        return input;
    }
    public static void main(String[] args) throws IOException {

        Calculator cal = new Calculator();
        String input = cal.getInput();

        System.out.println(cal.add(3,4));
        System.out.println(cal.subtract(5,4));
        System.out.println(cal.multiply(3,4));
        System.out.println(cal.divide(7,4));
    }
}
