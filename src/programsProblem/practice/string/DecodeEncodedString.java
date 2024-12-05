package programsProblem.practice.string;

import programsProblem.utils.DriverClass;

import java.util.Stack;

public class DecodeEncodedString implements DriverClass<String> {
    //GeeksForGeeks Question
    static void decodeStr(String str) {
        StringBuilder res = new StringBuilder();

        for (int i = 0;i < str.length();i++){
            if(i % 2 == 0){
                res.append(str.charAt(i));
            } else {
                res.insert(0, str.charAt(i));
            }
        }

        System.out.println(res);
    }

    @Override
    public void driverMethod() {
//        String str = "bbaa";
//        decodeStr(str);

//        String s = "3[a]2[bc]";
        String s = "2[a3[c2[xb1[d]]]y]";
        System.out.println(decodeString(s));
    }

    //LeetCode Question
    public String decodeString(String s) {
        Stack<Integer> countStk = new Stack<>();
        Stack<StringBuilder> stringStk = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            } else if(ch == '['){
                countStk.push(k);
                stringStk.push(res);
                res = new StringBuilder();
                k = 0;
            } else if(ch == ']'){
                StringBuilder temp = stringStk.pop();
                Integer currCount = countStk.pop();
                for (int i = 0;i < currCount;i++){
                    temp.append(res);
                }
                res = temp;
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
