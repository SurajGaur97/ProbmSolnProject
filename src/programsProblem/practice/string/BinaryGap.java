package programsProblem.practice.string;

import programsProblem.practice.common.DriverClass;

public class BinaryGap implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        printElement(binaryGap(448706));
    }

    public int binaryGap(int n) {
        String binary = Integer.toString(n, 2);
        int count = 0, max = 0;

        for (int i = 0;i < binary.length();i++){
            if(binary.charAt(i) == '0')
                count++;
            if(binary.charAt(i) == '1'){
                if(max < count + 1 && count > 0)
                    max = count + 1;
                count = 0;
            }
        }

        if(binary.contains("11") && max == 0) max = 1;

        return max;
    }
}
