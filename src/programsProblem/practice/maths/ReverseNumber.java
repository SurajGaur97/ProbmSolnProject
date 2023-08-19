package programsProblem.practice.maths;

public class ReverseNumber {
	public int getReverseNum(int num) {
		int res = 0;
		
		while(num != 0) {
			int temp = num % 10;
			res = res * 10 + temp;
			num /= 10;
		}
		
		return res;
	}
}
