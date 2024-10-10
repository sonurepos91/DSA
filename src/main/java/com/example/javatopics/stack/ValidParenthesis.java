package com.example.javatopics.stack;

import java.util.Stack;

public class ValidParenthesis<T> {

    public static void main (String[] args) {

        ValidParenthesis obj = new ValidParenthesis();

        String s = "[()]{}{[()()]()}{}";
        System.out.println(obj.isValidParenthesis(s));
    }

    private boolean isValidParenthesis (String T) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '[' || T.charAt(i) == '(' || T.charAt(i) == '{') {
                stack.push(T.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '[' && T.charAt(i) == ']' || stack.peek() == '{' && T.charAt(i) == '}' || stack.peek() == '(' && T.charAt(i) == ')') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }else{
                    stack.push(T.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
