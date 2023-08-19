package programsProblem.target75.string;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^0-9a-zA-Z]+", "").toLowerCase();
		
		for(int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		
		return true;
	}
}
