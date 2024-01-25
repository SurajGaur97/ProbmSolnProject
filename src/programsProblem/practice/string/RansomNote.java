package programsProblem.practice.string;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public void driverMethod() {
        System.out.println(canConstruct2("aab", "baa"));
    }

    private boolean canConstruct2(String ransomNote, String magazine) {
        for (int i = 0;i < ransomNote.length();i++){
            char r = ransomNote.charAt(i);

            int matchingIndex = magazine.indexOf(r);
            if(matchingIndex == -1){
                return false;
            }

            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
        }
        return true;
    }

    //By me and algo is of Leetcode
    private boolean canConstruct1(String ransomNote, String magazine) {
        for (int i = 0;i < ransomNote.length();i++){
            if(magazine.contains(String.valueOf(ransomNote.charAt(i)))){
                StringBuilder sb = new StringBuilder(magazine);
                magazine = sb.deleteCharAt(magazine.indexOf(ransomNote.charAt(i))).toString();
            } else {
                return false;
            }
        }
        return true;
    }

    //By me
    private boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();

        for (int i = 0;i < ransomNote.length();i++){
            if(!ransomMap.containsKey(ransomNote.charAt(i))){
                ransomMap.put(ransomNote.charAt(i), 1);
            } else {
                ransomMap.put(ransomNote.charAt(i), ransomMap.get(ransomNote.charAt(i)) + 1);
            }
        }

        for (int i = 0;i < magazine.length();i++){
            if(ransomMap.containsKey(magazine.charAt(i))){
                ransomMap.put(magazine.charAt(i), ransomMap.get(magazine.charAt(i)) - 1);

                if(ransomMap.get(magazine.charAt(i)) == 0){
                    ransomMap.remove(magazine.charAt(i));
                }
            }
        }

        return ransomMap.isEmpty();
    }
}
