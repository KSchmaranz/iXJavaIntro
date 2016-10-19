package datastruct;

import java.util.ArrayList;
import java.util.List;

public class Stack<TValue> {
    private List<TValue> content = new ArrayList<>();

    public void push(TValue value) {
        content.add(value);
    }

    public TValue pop() {
        TValue result = content.get(content.size() - 1);
        content.remove(content.size() - 1);
        return result;
    }

    public TValue top() {
        return content.get(content.size() - 1);
    }

    public static <TElement> Stack<TElement> stackOf(TElement... values) {
        Stack<TElement> result = new Stack<>();
        for (TElement element : values)
            result.push(element);
        return result;
    }
}
