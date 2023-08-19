package programsProblem.practice.web;

@FunctionalInterface
public interface Teting {
	void sum(int s, int b);
	
	default int me(String s) {
		return 0;
	}
	
	default int ab(int b) {
		return b;
		
	}
	default void nj() {
		System.out.println("abc");
	}
	
	static int be(int b) {
		return 0;
	}
	
	static int be(int b, int c) {
		return b+c;
	}
}
