package programsProblem.practice.stack;

import programsProblem.utils.DriverClass;

import java.util.Stack;

public class BalancedParentheses implements DriverClass<Boolean> {
    @Override
    public void driverMethod(){
//        String parentheses = "{[]{()}}";
        String parentheses = "]";
        printElement(isParenthesesBalanced(parentheses));
    }

    private Boolean isParenthesesBalanced(String parentheses){
        Stack<Character> stk = new Stack<>();

        for(char c : parentheses.toCharArray()){
            if(c == '(' || c == '{' || c == '[')
                stk.push(c);

            if(c == ')' || c == '}' || c == ']'){
                char peek = !stk.isEmpty() ? stk.peek() == '(' ? ')' : stk.peek() == '{' ? '}' : ']' : ' ';
                if(!stk.isEmpty() && c == peek)
                    stk.pop();
                else
                    return false;
            }
        }

        return stk.isEmpty();
    }
}
