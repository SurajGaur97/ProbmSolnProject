package programsProblem.practice.patterns;

public class DiamondPattern {
    public void solidDiamond(int height) {
        for(int i = 0; i < height; i++) {
            for (int j = (height / 2) + 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 1; i >= 0; i--) {
            for (int j = (height / 2) + 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void hollowDiamond(int height) {
        for(int i = 0; i < height; i++) {
            for (int j = (height / 2) + 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 1; i >= 0; i--) {
            for (int j = (height / 2) + 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void solidHalfDiamond(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void hollowedDiamInRect(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = height - 1; j >= i; j--) {
                System.out.print("* ");
            }
            for(int j = 0; j <= 2 * i - 1; j++) {
                if(i != 0) {
                    System.out.print("  ");
                }
            }
            for(int j = height - 1; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 1; i >= 0; i--) {
            for(int j = height - 1; j >= i; j--) {
                System.out.print("* ");
            }
            for(int j = 0; j <= 2 * i - 1; j++) {
                if(i != 0) {
                    System.out.print("  ");
                }
            }
            for(int j = height - 1; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void diamondDiagonalNSide(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < 2 * height - 1; j ++) {
                if(i + j == height - 1 || j == height - 1 || i == height - 1 || j - i == height - 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        // Reverse
        for(int i = height - 2; i >= 0; i--) {
            for(int j = 0; j < 2 * height - 1; j ++) {
                if(i + j == height - 1 || j == height - 1 || j - i == height - 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void diamondDiagonalNSide1(int height) {
        for(int i = 0; i < (height + 1) / 2; i++) {
            for(int j = 0; j < height; j++) {
                if(i + j == (height + 1) / 2 - 1 || j == (height + 1) / 2 - 1 || i == (height + 1) / 2 - 1 || j - i == (height + 1) / 2 - 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        // Reverse
        for(int i = (height / 2) - 1; i >= 0; i--) {
            for(int j = 0; j < height; j++) {
                if(i + j == (height + 1) / 2 - 1 || j == (height + 1) / 2 - 1 || i == (height + 1) / 2 - 1 || j - i == (height + 1) / 2 - 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
