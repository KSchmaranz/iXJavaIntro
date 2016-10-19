package datastruct;

import static datastruct.Stack.stackOf;

public class StackDemoMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Stack<String> justAStringStack = stackOf("one", "two", "three");
        System.out.println(justAStringStack.pop());
        System.out.println(justAStringStack.pop());
        System.out.println(justAStringStack.pop());

        Stack<Integer> intStack = new Stack<>();
        doSomethingSilly(intStack);
        int result = intStack.pop();
    }

    private static void doSomethingSilly(Stack stack) {
        stack.push("oops");
    }
}
