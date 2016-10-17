package stackcalculator;

public class StackCalculator {
    public static void main(String[] args) {
        CalculatorImpl calc = new CalculatorImpl(16);

        calc.push(10.0);
        calc.push(20.0);
        calc.add();
        System.out.println(calc.top());
    }
}
