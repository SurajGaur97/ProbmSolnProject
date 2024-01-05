package programsProblem.practice.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings {
    public void driverMethod() {
        System.out.println(isIsomorphic2("bbbaaaba", "aaabbbba"));
    }

    private boolean isIsomorphic3(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> hmS = new HashMap<>();
        HashMap<Character, Boolean> hmT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(hmS.containsKey(charS)) {
                if(hmS.get(charS) != charT) {
                    return false;
                }
            } else {
                if(hmT.containsKey(charT)) {
                    return false;
                } else {
                    hmS.put(charS, charT);  //mapping the character first
                    hmT.put(charT, true);   //then setting true for chars which is used in hmS.
                }
            }
        }
        return true;
    }

    private boolean isIsomorphic2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Boolean> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)) {
                if(map1.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if(map2.containsKey(ch2)) {
                    return false;
                } else {
                    map1.put(ch1, ch2);
                    map2.put(ch2, true);
                }
            }
        }

        return true;
    }

    private boolean isIsomorphic1(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> hmS = new HashMap<>();
        HashMap<Character, Integer> hmT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!hmS.containsKey(s.charAt(i))) {
                hmS.put(s.charAt(i), 1);
            } else {
                hmS.put(s.charAt(i), hmS.get(s.charAt(i)) + 1);
            }
            if(!hmT.containsKey(t.charAt(i))) {
                hmT.put(t.charAt(i), 1);
            } else {
                hmT.put(t.charAt(i), hmT.get(t.charAt(i)) + 1);
            }
        }

        int[] patternS = new int[s.length()];
        int[] patternT = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            patternS[i] = hmS.get(s.charAt(i));
            patternT[i] = hmT.get(t.charAt(i));
        }

        return Arrays.equals(patternS, patternT);
    }

    private boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new LinkedHashMap<>();
        Map<Character, Character> revMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            revMap.put(t.charAt(i), s.charAt(i));
        }

        for (Map.Entry<Character, Character> entry : map.entrySet()) {
        }

        return true;
    }
}
