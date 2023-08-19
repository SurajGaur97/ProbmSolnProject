package programsProblem.practice.patterns;

public class RectanglePatterns {
    public void solidRectangle(int height, int breath) {

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < breath; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void hollowRectangle(int height, int breath) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < breath; j++) {
                if(i == 0 || i == height - 1) {
                    System.out.print("* ");
                }
                else {
                    if(j == 0 || j == breath - 1) {
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

    public void diagonalAndSides(int height) {
        System.out.println();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < height; j++) {
                if(i == 0 || i == height - 1 || i == j || j == height - i - 1 || j == 0 || j == height - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

}
