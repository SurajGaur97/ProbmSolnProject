package programsProblem.practice.maths;

public class CheckPrimeNum {
	
	public Boolean isPrimeNum(int num) {
		for(int i = 2; i <= num / 2; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public void checkPrimeNum(int num) {
		if(isPrimeNum(num))
			System.out.println("Yes! Prime Number.");
		else
			System.out.println("No! Not Prime Number.");
	}
}
