
public class CalculatorImpl implements Comparable<CalculatorImpl> {
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

    public int getSize() {
        return size;
    }

    public double bottom(int idx) {
        return stack[idx];
    }

    @Override
    public String toString() {
        String result = "[StackCalculator<stack: ";
        boolean firstElement = true;
        for (int idx = 0; idx < size; ++idx) {
            if (!firstElement)
                result += ", ";
            firstElement = false;
            result += bottom(idx);
        }
        result += ">]";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CalculatorImpl))
            return false;
        CalculatorImpl other = (CalculatorImpl)obj;
        if (getSize() != other.getSize())
            return false;
        for (int idx = 0; idx < getSize(); ++idx) {
            if (bottom(idx) != other.bottom(idx))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int idx = 0; idx < getSize(); ++idx)
            hash = hash * 31 + Double.hashCode(bottom(idx));
        return hash;
    }

    @Override
    public int compareTo(CalculatorImpl other) {
        for (int srcIdx = 0; srcIdx < getSize(); ++srcIdx) {
            if (other.getSize() <= srcIdx)
                break;
            if (bottom(srcIdx) == other.bottom(srcIdx))
                continue;
            return bottom(srcIdx) < other.bottom(srcIdx) ? -1 : 1;
        }
        if (getSize() == other.getSize())
            return 0;
        return getSize() < other.getSize() ? -1 : 1;
    }
}
