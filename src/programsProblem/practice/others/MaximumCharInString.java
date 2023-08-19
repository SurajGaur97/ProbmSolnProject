package programsProblem.practice.others;

public class MaximumCharInString {
	public String solution(String S) {
        // write your code in Java SE 8
        char ch = S.charAt(0);
        int ascii = ch;
        String result = "NO";
        for(int i = 1; i < S.length(); i++) {
            if(ascii < (int) S.charAt(i)) {
                if(S.contains(Character.toString(Character.toUpperCase(S.charAt(i))))) {
                    ch = S.charAt(i);
                    ascii = (int) S.charAt(i);
                    result = Character.toString(Character.toUpperCase(S.charAt(i)));
                }
            }
        }
        return result;
    }
}
