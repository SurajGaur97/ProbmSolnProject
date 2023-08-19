package programsProblem.target75.string;

public class PalindromicSubstrings {
	
	public int countSubstrings1(String s) {
		int l = 0, r = 0, count = 0;
		
		while(l < s.length()) {
			String res = "";
			
			while(r < s.length()) {
				for(int i = l; i <= r; i++) {
					res += s.charAt(i);
				}
				
				if(isPalindrom(res)) {
					count++;
				}
				r++;
				res = "";
			}
			l++;
			r = l;
		}
		return count;
	}
	
	
	public int countSubstrings(String s) {
        int l = 0, r = 0;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	while(l >= 0 && r < s.length()) {
        		l = i; r = i;
        		String str = Character.toString(s.charAt(l)) + Character.toString(s.charAt(i)) + 
        				Character.toString(s.charAt(r));
        		if(isPalindrom(str)) {
        			count++;
        		}
        		l--;
        		r++;
        	}
        	r++;
        }
        return count;
    }
	
	private boolean isPalindrom(String str) {
		for(int i = 0, j = str.length() - 1; i < str.length()/2; i++, j--) {
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}
}
