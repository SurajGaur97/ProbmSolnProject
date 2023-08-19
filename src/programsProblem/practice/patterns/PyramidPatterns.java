package programsProblem.practice.patterns;

public class PyramidPatterns {
    public void halfPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void invertedHalfPyramid(int height) {
        for(int i = height - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void hollowedInvertedHalfPyramid(int height) {
        for(int i = height - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                if(i == 0 || i == height - 1) {
                    System.out.print("* ");
                }
                else {
                    if(j == 0 || j == i) {
                        System.out.print("* ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void fullyPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for (int j = (height / 2) + 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void invertedFullyPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < height; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void hollowedFullyPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for (int j = (height / 2) + 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if(i == 0 || i == height - 1){
                    System.out.print("* ");
                }
                else {
                    if(j == 0 || j == i) {
                        System.out.print("* ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }

}
