package programsProblem.practice.patterns;

import java.util.HashSet;
import java.util.Set;

public class ArrowPrinting {
    public void printArrow(int height) {
        for(int i = 0; i < (height / 2) * 3; i++) {
            for(int j = 0; j < (height / 2) * 3; j++) {
                if(i == j || i == (height + 1) / 2 - 1 || i + j == (height / 2) * 3 - 1) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
                if(j >= (height / 2) && j <= height) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        Set<Character> set = new HashSet<>();
        //set.add()
    }
}
