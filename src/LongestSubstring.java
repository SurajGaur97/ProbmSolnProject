import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String str = "xyzabc";
        int maxSubstring = 0;
        int temp = 0;
        Set<Character> set = new HashSet<>();

        for(char c: str.toCharArray()) {
            if(set.contains(c)) {
                set.clear();
                temp = 1;
            } else {
                set.add(c);
                temp++;
                maxSubstring = Math.max(maxSubstring, temp);
            }
        }
        System.out.println(maxSubstring);
    }
}
