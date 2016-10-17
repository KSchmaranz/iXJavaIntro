package stackcalculator;

public class CalculatorImpl {
    private double[] stack;
    private int size;

    CalculatorImpl(int size) {
        stack = new double[size];
    }

    public void push(double value) {
        stack[size] = value;
        ++size;
    }

    public void add() {
        double rhs = pop();
        double lhs = pop();
        push(lhs + rhs);
    }

    public void subtract() {
        double rhs = pop();
        double lhs = pop();
        push(lhs - rhs);
    }

    public double pop() {
        double result = top();
        size--;
        return result;
    }

    public double top() {
        return stack[size - 1];
    }

    public String operand(String value) {
        double parsedValue = Double.valueOf(value);
        push(parsedValue);
        return String.valueOf(parsedValue);
    }

    public String execute(String operator) {
        switch(operator) {
            case "+":
                add();
                break;
            case "-":
                subtract();
                break;
            default:
                throw new IllegalArgumentException("unknown operator: " + operator);
        }
        return new Double(top()).toString();
    }
}
