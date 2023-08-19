package programsProblem.practice.array;

import java.util.Arrays;

public class Maximum69No {
	public void solution(int num) {
		int[] arr = new int[4];
		int i = 3;
		while (num != 0) {
			arr[i--] = num % 10;
			num /= 10;
		}
		Arrays.stream(arr).forEach(value -> System.out.println(value));
		int ans = 0, mul = 1;
		for (i = 3; i >= 0; i--) {
			ans += (mul * arr[i]);
			mul *= 10;
		}
		System.out.println(ans);
	}
}
