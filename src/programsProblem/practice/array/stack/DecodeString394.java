package programsProblem.practice.array.stack;

import programsProblem.practice.common.DriverClass;

import java.util.Stack;

public class DecodeString394 implements DriverClass<String> {
    @Override
    public void driverMethod() {
//        String s = "3[a]2[bc]";
        String s = "3[a2[c]]";
        printElement(decodeString(s));
    }

    public String decodeString(String s) {
        Stack<Character> chrs = new Stack<>();
        Stack<Integer> dgts = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                k = k * 10 + (c - '0'); //if digit is 2 or more digits like 10, 100.
                dgts.push(k);
                k = 0;
            }
            else if(c != ']') {
                chrs.push(c);
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                char top = chrs.pop();
                while(top != '[') {
                    tmp.append(top);
                    top = chrs.pop();
                }
                tmp.reverse();

                int occ = dgts.pop();
                StringBuilder occr = new StringBuilder();
                if(!strs.isEmpty()) occr.append(strs.pop());
                for(int j = 0; j < occ; j++) {
                    occr.append(tmp);
                }
                strs.push(occr);
            }
        }

        return strs.pop().toString();
    }
}
