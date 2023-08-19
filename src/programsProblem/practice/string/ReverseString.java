package programsProblem.practice.string;

public class ReverseString {
	
	String doReverse(String str) {
		String resStr = "";
		for(int i = 0; i < str.length(); i++) {
			resStr = str.charAt(i) + resStr;
		}
		return resStr;
	}
	
	String doReverse1(String str) {
		String resStr = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			resStr = resStr + str.charAt(i);
		}
		return resStr;
	}
	
	public void getReverse(String str) {
		System.out.println(doReverse(str));
	}
}
