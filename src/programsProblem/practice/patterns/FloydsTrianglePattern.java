package programsProblem.practice.patterns;

public class FloydsTrianglePattern {
    public void printFloydsTriangle(int height) {
        int count = 1;
        for(int i = 0; i <= height; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }
}
