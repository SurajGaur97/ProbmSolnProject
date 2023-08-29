package programsProblem.company.wonderlendhubs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSubstringWithUniqueChars {
    public void driverMethod() {
        getSubstring("abcdabcdefgdf");
    }

    private int getSubstring(String str) {
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        String indexes = "";

        while(r < str.length()) {
            if(!map.containsKey(str.charAt(r))) {
                map.put(str.charAt(r), r);
                r++;
            }
            else {
                indexes += l + "-" + (r - 1) + ",";

                map.put(str.charAt(r), r);
                l = map.get(str.charAt(r));
                r++;
            }
        }
        System.out.println(indexes);
        return 0;
    }

}
