import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackCalculatorShell {
    private static CalculatorImpl calculator = new CalculatorImpl(16);

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (readAndProcessNextInput(bufferedReader)) {
        }
    }

    private static boolean readAndProcessNextInput(BufferedReader bufferedReader)
            throws IOException {
        printStack();
        System.out.printf(" > ");
        String nextLine = bufferedReader.readLine();
        if (nextLine.equals("exit"))
            return false;
        if (nextLine.charAt(0) >= '0' && nextLine.charAt(0) <= '9')
            System.out.println(calculator.operand(nextLine));
        else
            System.out.println(calculator.execute(nextLine));
        return true;
    }

    private static void printStack() {
        System.out.println("----------");
        for(int idx = 0; idx < calculator.getSize(); ++idx)
            System.out.println(calculator.bottom(idx));
        System.out.println("----------");
    }
}
