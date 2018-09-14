package stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> all = new Stack<>();
        all.push("hello");
        all.push("World");
        System.out.println(all.pop());
        System.out.println(all.pop());
    }
}
