package programsProblem.target75.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
	public int minWindow1(String s, String t) {
		if(s.length() < t.length()) return 0;
		
        int l = 0, r = 0, minLen = s.length();
        HashMap<Character, Integer> mapT = new HashMap<>();
        String res = "";
        
        for(int i = 0; i < t.length(); i++) {
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
            		for(int i = l; i <= r; i++) {
            			res += s.charAt(i);
            		}
        		}
        		
        		//Resetting the map values
        		for(int i = 0; i < t.length(); i++) {
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
        
        for(int i = 0; i < t.length(); i++) {
        	setT.add(t.charAt(i));
        }
        
        while(r < s.length()) {
        	if(setT.contains(s.charAt(r))) {
        		setT.remove(s.charAt(r));
        	}
        	if(setT.isEmpty()){
        		minLen = Math.min(minLen, (r - l + 1));
        		
        		//Building result String
        		res = "";
        		for(int i = l; i <= r; i++) {
        			res += s.charAt(i);
        		}
        		
        		//Resetting set values
        		for(int i = 0; i < t.length(); i++) {
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
