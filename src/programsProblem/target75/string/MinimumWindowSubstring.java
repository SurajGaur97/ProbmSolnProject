package programsProblem.target75.string;

import programsProblem.utils.DriverClass;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumWindowSubstring implements DriverClass<Integer> {

    @Override
    public void driverMethod(){
//		String s = "ADOBECODEBANC", t = "ABC";	//output: "BANC"
//		String s = "a", t = "aa";	//output: ""
        String s = "cabwefgewcwaefgcf", t = "cae";    //output: "cwae"
        printElement(minWindow2(s, t));
    }

    public int minWindow2(String s, String t){
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for(char chr : t.toCharArray()){
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        char[] chA = s.toCharArray();

        while (end < chA.length){
            int endCnt = map.getOrDefault(chA[end], 0);
            if(endCnt > 0)
                count--;

            if(map.containsKey(chA[end]))
                map.put(chA[end], map.get(chA[end]) - 1);
            end++;

            while (count == 0){
                if(end - start < minLen){
                    startIndex = start;
                    minLen = end - start;
                }
                int srtCnt = map.getOrDefault(chA[start], 0);
                if(srtCnt == 0)
                    count++;
                if(map.containsKey(chA[start]))
                    map.put(chA[start], map.get(chA[start]) + 1);
                start++;
            }
        }

        System.out.println(new String(chA, startIndex, minLen));

        return minLen;
    }

    public int minWindow1(String s, String t){
        if(s.length() < t.length()) return 0;

        int l = 0, r = 0, minLen = s.length();
        HashMap<Character, Integer> mapT = new HashMap<>();
        String res = "";

        for(int i = 0;i < t.length();i++){
            if(!mapT.containsKey(t.charAt(i)))
                mapT.put(t.charAt(i), 1);
            else
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
        }

        while(r < s.length()) {
            if(mapT.containsKey(s.charAt(r)) && mapT.get(s.charAt(r)) > 0) {
                mapT.put(s.charAt(r), mapT.get(s.charAt(r)) - 1);
            }

            if(Collections.max(mapT.values()) == 0) {
                if(minLen >= (r - l + 1)) {
                    minLen = r - l + 1;

                    //Building result String
                    res = "";
                    for(int i = l;i <= r;i++) {
                        res += s.charAt(i);
                    }
                }

                //Resetting the map values
                for(int i = 0;i < t.length();i++) {
                    mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
                }

                l++;
                r = l;
                r--;
            }
            r++;
        }

        System.out.println(res);
        return minLen;
    }

    public int minWindow(String s, String t) {
        int l = 0, r = 0, minLen = s.length();
        HashSet<Character> setT = new HashSet<>();
        String res = "";

        for(int i = 0;i < t.length();i++) {
            setT.add(t.charAt(i));
        }

        while(r < s.length()) {
            setT.remove(s.charAt(r));
            if(setT.isEmpty()){
                minLen = Math.min(minLen, (r - l + 1));

                //Building result String
                res = "";
                for(int i = l;i <= r;i++) {
                    res += s.charAt(i);
                }

                //Resetting set values
                for(int i = 0;i < t.length();i++) {
                    setT.add(t.charAt(i));
                }
                l++;
                r = l;
                r--;
            }
            r++;
        }

        System.out.println(res);
        return minLen;
    }
}
