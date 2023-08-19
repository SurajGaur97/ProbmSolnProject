package programsProblem.easyLeetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> sym = new HashMap<>();
        sym.put('I', 1); sym.put('V', 5); sym.put('X', 10); sym.put('L', 50); sym.put('C', 100);
        sym.put('D', 500); sym.put('M', 1000);

        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i == s.length() - 1) {
                res += sym.get(s.charAt(i));
            }
            else if(sym.get(s.charAt(i)) < sym.get(s.charAt(i + 1))) {
                res -= sym.get(s.charAt(i));
            }
            else if(sym.get(s.charAt(i)) >= sym.get(s.charAt(i + 1))) {
                res += sym.get(s.charAt(i));
            }
        }

        return res;
    }
}
