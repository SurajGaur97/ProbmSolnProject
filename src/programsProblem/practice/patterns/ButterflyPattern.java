package programsProblem.practice.patterns;

public class ButterflyPattern {
    public void printButterflyPattern(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for(int j = 2 * height - 2 * i - 3; j >= 0; j--) {
                System.out.print("  ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 1; i >= 0 ; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for(int j = 2 * height - 2 * i - 3; j >= 0; j--) {
                System.out.print("  ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
