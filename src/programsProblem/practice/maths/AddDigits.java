package programsProblem.practice.maths;

public class AddDigits {
    public void driverMethod() {
        System.out.println(addDigits(38));
    }

    private int addDigits1(int num) {
        if(num == 0) return 0;
        else if(num == 9) return 9;
        else return num % 9;
    }

    private int addDigits(int num) {
        int temp = num;
        int sum = 0;

        do {
            while (temp != 0) {
                int a = temp % 10;
                sum = sum + a;
                temp = temp / 10;
            }
            if(sum > 9) {
                temp = sum;
                sum = 0;
            }
        } while (temp > 9);

        return sum;
    }
}
