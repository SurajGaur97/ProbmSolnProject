package programsProblem.target75.string;

import programsProblem.utils.DriverClass;

import java.util.Stack;

public class ValidParentheses implements DriverClass<Boolean> {

    @Override
    public void driverMethod(){
//		String str = "(])";
        String str = "()[]{}";
        printElement(isValid3(str));
    }

    public boolean isValid3(String s){
        Stack<Character> stk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(') stk.push(')');
            else if(ch == '{') stk.push('}');
            else if(ch == '[') stk.push(']');
            else {
                if(!stk.isEmpty() && stk.peek() == ch)
                    stk.pop();
                else return false;
            }
        }

        return stk.isEmpty();
    }

    //Simplest Solution
    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char chr = s.charAt(i);

            if(chr == ')'){
                if(stack.peek() == '('){
					stack.pop();
				}else {
					return false;
				}
			}else if(chr == '}') {
				if(stack.peek() == '{') {
					stack.pop();
				}else {
					return false;
				}
			}else if(chr == ']') {
				if(stack.peek() == '[') {
					stack.pop();
				}else {
					return false;
				}
			}else {
				stack.push(chr);
			}
		}
		
		return stack.isEmpty();
	}
	
	//Not passes all test cases. Fails at-- (])
	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') 
				stack.push(s.charAt(i));
			else {
				if(stack.empty())
					return false;
				else {
					if ((s.charAt(i) == ')' && stack.peek() == '(') ||
						(s.charAt(i) == '}' && stack.peek() == '{') || 
						(s.charAt(i) == ']' && stack.peek() == '[')) {
						stack.pop();
					}
					else return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	//100% works
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(')');
			}else if(s.charAt(i) == '{') {
				stack.push('}');
			}else if(s.charAt(i) == '[') {
				stack.push(']');
			}
			
			else if(s.charAt(i) == ')') {
				if(!stack.empty() && stack.peek() == ')')
					stack.pop();
				else return false;
			} else if(s.charAt(i) == '}') {
				if(!stack.empty() && stack.peek() == '}')
					stack.pop();
				else return false;
			} else if(s.charAt(i) == ']') {
				if(!stack.empty() && stack.peek() == ']')
					stack.pop();
				else return false;
			}
		}
		
		return stack.isEmpty();
	}

}
