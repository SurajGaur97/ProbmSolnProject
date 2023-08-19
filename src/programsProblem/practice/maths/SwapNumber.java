package programsProblem.practice.maths;

public class SwapNumber {
	
	//Without using third variable.
	void swapNumber(int x, int y) {
		x = x + y;
		y = x - y;
		x = x - y;
	}
	
	void swapNumber1(int x, int y) {
		int temp = x;
		y = x;
		x = temp;
	}
	
	public void getSwapedNumber(int x, int y) {
		swapNumber(x, y);
		System.out.println("Swaped Number is: " + x + " " + y);
	}
}
