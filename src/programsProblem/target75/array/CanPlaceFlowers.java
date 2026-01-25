package programsProblem.target75.array;

import programsProblem.utils.DriverClass;

public class CanPlaceFlowers implements DriverClass<Boolean> {

    @Override
    public void driverMethod() {
        int[] flowerbed = new int[]{0,0,1,0,0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1 && flowerbed[0] == 0)
            return true;

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                if(i != 0 && i < flowerbed.length - 1) {
                    if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                        i++;
                    }
                }
                else if(i == 0) {
                    if(flowerbed[i + 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                        i++;
                    }
                }
                else if(i == flowerbed.length - 1) {
                    if(flowerbed[i - 1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                        i++;
                    }
                }
            }
        }
        return n <= 0;
    }
}
