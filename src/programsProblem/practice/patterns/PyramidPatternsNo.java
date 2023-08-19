package programsProblem.practice.patterns;

public class PyramidPatternsNo {
    public void halfPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    public void invertedHalfPyramid(int height) {
        for(int i = height - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    public void hollowedHalfPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == 0 || i == height - 1) {
                    System.out.print((j + 1) + " ");
                }
                else {
                    if(j == 0 || j == i) {
                        System.out.print((j + 1) + " ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void hollowedInvertedHalfPyramid(int height) {
        for(int i = height - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                if(i == 0) {
                    System.out.print(height + " ");
                }
                else if(i == height - 1) {
                    System.out.print((j + 1) + " ");
                }
                else {
                    if(j == 0) {
                        System.out.print((height - i) + " ");
                    }
                    else if (j == i) {
                        System.out.print(height + " ");
                    } else {
                        System.out.print("  ");
                    }
                }
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
                System.out.print((i + j + 1) + " ");
            }
            for(int j = ((2 * i + 1) / 2) - 1; j >= 0 ; j--) {
                System.out.print((i + j + 1) + " ");
            }
            System.out.println();
        }
    }

    public void hollowedFullPyramid(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = i ; j < height; j++) {
                System.out.print("  ");
            }
            if(i == 0 || i == height - 1) {
                for(int j = 0; j <= i; j++) {
                    System.out.print((j + 1) + "   ");
                }
            }
            else {
                for(int j = 0; j < (2 * i + 1); j++) {
                    if(j == 0) {
                        System.out.print(j + 1 + " ");
                    }
                    else if (j == 2 * i) {
                        System.out.print(i + 1 + " ");
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
