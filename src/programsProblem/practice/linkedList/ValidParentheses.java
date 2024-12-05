package programsProblem.practice.linkedList;

import java.util.ArrayList;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid1(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char chr = s.charAt(i);

            if(chr == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                } else {
                    return false;
                }
            } else if(chr == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            } else if(chr == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(chr);
            }
        }

        return stack.isEmpty();
    }

    //Wrong Solution
    public boolean isValid(String s){
        ArrayList<String> chars = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            chars.add(Character.toString(s.charAt(i)));
        }
        int length = chars.size();
        while (length != 0){
            if(chars.contains(")")){
                if(chars.contains("(")){
                    chars.remove("(");
                    chars.remove(")");
                    length -= 2;
                }
            }
            if(chars.contains("}")){
                if(chars.contains("{")){
                    chars.remove("{");
                    chars.remove("}");
                    length -= 2;
                }
            }
            if(chars.contains("]")){
                if(chars.contains("[")){
                    chars.remove("[");
                    chars.remove("]");
                    length -= 2;
                }
            }
            if(!chars.contains(")") && !chars.contains("}") && !chars.contains("]"))
                break;
        }
        return length == 0;
    }
}
