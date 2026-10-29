package com.bbd.day25;
import java.util.*;
// BBD #3 - Valid Parentheses - Stack O(n) - BBD loves Stack questions
public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='[') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((c==')' && top!='(') || (c=='}' && top!='{') || (c==']' && top!='[')) return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()[]{}")); // true
        System.out.println(v.isValid("(]")); // false
    }
}
