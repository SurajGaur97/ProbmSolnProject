package programsProblem.easyLeetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0, i = s.length() - 1;
        while(s.charAt(i) != 32) {
            count++;
            i--;
            if(i < 0) break;
        }
        return count;
    }
}
