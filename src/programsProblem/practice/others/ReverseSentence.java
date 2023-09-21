package programsProblem.practice.others;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseSentence {
    public void driverMethod() {
        String str = "This is a Java Program";
        reverseSentence2(str);
    }

    private void reverseSentence2(String str) {
        String reversedString = Arrays
                .stream(str.split(" "))
                .collect(Collectors.toList())
                .stream().reduce((word1, word2) -> word2 + " " + word1)
                .orElse("");

        System.out.println(reversedString);
    }

    private void reverseSentence1(String str) {
        String[] strList = str.split(" ");

        str = " ";
        Stack<String> stk = new Stack<>();
        for (String temp : strList) {
            stk.push(temp);
        }

        while (!stk.empty()) {
            str += stk.pop() + " ";
        }

        System.out.print(str);
    }

    private void reverseSentence(String str) {
        String[] strList = str.split(" ");

        str = "";
        for (String temp : strList) {
            str = temp + " " + str;
        }

        System.out.print(str);
    }
}
