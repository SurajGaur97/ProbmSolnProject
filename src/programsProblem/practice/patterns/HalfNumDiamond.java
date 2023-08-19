package programsProblem.practice.patterns;

public class HalfNumDiamond {
    public void solidHalfNumDiamond(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print((height - 1) + i);
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print((height - 1) + i);
            }
            System.out.println();
        }
    }

    public void solidHalfStarNumDiamond(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print(i + 1);
                if(j != i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                System.out.print(i + 1);
                if(j != i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public void solidHalfStarNumIncDiamond(int height) {
        int cons = 0;
        String[] str = new String[height];
        for(int i = 0; i < height; i++) {
            str[i] = "";
            for(int j = 0; j <= i; j++) {
                str[i] += ++cons;
                if(j != i) {
                    str[i] += "*";
                }
            }
            System.out.println(str[i]);
        }
        //reverse
        for(int i = height - 1; i >= 0; i--) {
            System.out.println(str[i]);
        }
    }

    public void solidOddHalfDiamond(int height) {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j <= ((2 * i + 1) / 2); j++) {
                if(j == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(j + " ");
                }
            }
            for(int j = ((2 * i + 1) / 2) - 1; j >= 0; j--) {
                if(j == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        //reverse
        for(int i = height - 2; i >= 0; i--) {
            for(int j = 0; j <= ((2 * i + 1) / 2); j++) {
                if(j == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(j + " ");
                }
            }
            for(int j = ((2 * i + 1) / 2) - 1; j >= 0; j--) {
                if(j == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

}
