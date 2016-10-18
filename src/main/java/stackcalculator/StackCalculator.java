package stackcalculator;

public class StackCalculator {
    public static void main(String[] args) {
        CalculatorImpl calc = new CalculatorImpl(16);
        CalculatorImpl calc2 = new CalculatorImpl(16);

        calc.push(2.0);
        calc.push(42.0);
        calc2.push(2.0);

        System.out.println(calc.compareTo(calc2));

        System.out.println(calc.equals(calc2));
        System.out.println(calc.hashCode());
        System.out.println(calc2.hashCode());
    }
}
