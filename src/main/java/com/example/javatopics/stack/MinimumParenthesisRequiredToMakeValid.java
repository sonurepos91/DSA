package com.example.javatopics.stack;

import java.util.Stack;

public class MinimumParenthesisRequiredToMakeValid<T> {

    public static void main (String[] args) {

        MinimumParenthesisRequiredToMakeValid obj = new MinimumParenthesisRequiredToMakeValid();

        String s = ")()())";
        System.out.println(obj.minimumParenthesisRequired(s));
    }

    private T minimumParenthesisRequired (String T) {


        Stack<Character> stack = new Stack<>();
        StringBuilder longestString = new StringBuilder();

        for(int i=0;i< T.length();i++){
            if(T.charAt(i)== '{' || T.charAt(i)== '[' || T.charAt(i)== '('){
                stack.push(T.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    if(T.charAt(i)== ']' && stack.peek() =='[' || T.charAt(i)== '}' && stack.peek() =='{' || T.charAt(i)== ')' && stack.peek() =='('){
                        longestString.append(stack.peek());
                        longestString.append(T.charAt(i));
                        stack.pop();
                    }
                }else{
                    stack.push(T.charAt(i));
                }
            }
        }
        return (T) String.valueOf(longestString);
    }
}
