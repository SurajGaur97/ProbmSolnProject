package programsProblem.practice.patterns;

public class PascalsTrianglePattern {
    public void printPascalsTriangle(int height) {
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j < i / 2; j++) {
                System.out.print("" + " ");
            }
            System.out.println();
        }
    }
}
