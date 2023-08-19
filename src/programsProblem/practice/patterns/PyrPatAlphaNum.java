package programsProblem.practice.patterns;

public class PyrPatAlphaNum {
    public void halfPyramidOddNum(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < ((2 * i + 1) / 2) + 1; j++) {
                System.out.print((j + 1) + " ");
            }
            for(int j = ((2 * i + 1) / 2) - 1; j >= 0; j--) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    public void halfPyramidOddAlpha(int height) {
        char[] alpha = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
                'P', 'Q', 'R', 'S','T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < ((2 * i + 1) / 2) + 1; j++) {
                System.out.print(alpha[j] + " ");
            }
            for(int j = ((2 * i + 1) / 2) - 1; j >= 0; j--) {
                System.out.print(alpha[j] + " ");
            }
            System.out.println();
        }
    }

    public void fullPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = i ; j < height; j++) {
                System.out.print("  ");
            }
            for(int j = 0; j < ((2 * i + 1) / 2) + 1; j++) {
                System.out.print((j + 1) + " ");
            }
            for(int j = ((2 * i + 1) / 2) - 1; j >= 0 ; j--) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    public void fullPyramidStarNum(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = i ; j < ((3 * height) / 2) + 1; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < (i + 1); j++) {
                System.out.print((i + 1) + "*");
            }
            for(int j = i ; j < ((3 * height) / 2); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
