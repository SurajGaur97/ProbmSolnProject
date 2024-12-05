package programsProblem.target75.string;

import programsProblem.utils.DriverClass;

import java.util.*;

public class GroupAnagrams implements DriverClass<String> {
    @Override
    public void driverMethod(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        printElementLst(groupAnagrams3(strs));
    }

    public List<List<String>> groupAnagrams3(String[] strs){
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int ndx = 0;

        for(String str : strs){
            if(!map.containsKey(sortIt(str))){
                map.put(sortIt(str), ndx);
                res.add(new ArrayList<>());
                res.get(ndx).add(str);
                ndx++;
            } else res.get(map.get(sortIt(str))).add(str);
        }
        return res;
    }

    private String sortIt(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


    //Using mapping method O(N.K)
    public List<List<String>> groupAnagram2(String[] strs){
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();

        for(int i = 0;i < strs.length;i++){
            HashMap<Character, Integer> chars = new HashMap<>();

            for(int j = 0;j < strs[i].length();j++){
                if(!chars.containsKey(strs[i].charAt(j))){
					chars.put(strs[i].charAt(j), 1);
				}
				else {
					chars.put(strs[i].charAt(j), chars.get(strs[i].charAt(j)) + 1);
				}
			}
			
			if(!map.containsKey(chars)) {
				map.put(chars, new ArrayList<String>(Collections.singletonList(strs[i])));
			}
			else {
				map.get(chars).add(strs[i]);
			}
		}
		
		List<List<String>>listStrs = new ArrayList<>();
		for(List<String> str: map.values()) {
			listStrs.add(str);
		}
		
		return listStrs;
	}
	
	//Using shorting method O(N.K.log(K))
	public List<List<String>> groupAnagrams1(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		List<List<String>> listOfStrs = new ArrayList<>();
		
		for(int i = 0; i < strs.length; i++) {			
	        char[] chars = strs[i].toCharArray();
	        Arrays.sort(chars);
	        String sorted = new String(chars);
	        
			if(!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<String>(Collections.singletonList(strs[i])));
			}
			else {
				map.get(sorted).add(strs[i]);
			}
		}
		
		for(List<String> sts: map.values()) {
			listOfStrs.add(sts);
		}
		
		return listOfStrs;
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramList = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(strs));

        for(String ana : set) {
            List<String> list = new ArrayList<>();
            for(int j = 0; j < strs.length; j++) {
                if(isAnagram(ana, strs[j])) {
                    list.add(strs[j]);
                }
            }
            Set<String> tempSet = new HashSet<>(Arrays.asList(strs));
            for(String str : list) {
                tempSet.remove(str);
                //set.remove(str);
            }
            set = tempSet;
            anagramList.add(list);
        }

        return anagramList;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0) {
            	map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        return Collections.max(map.values()) == 0;
    }
}
