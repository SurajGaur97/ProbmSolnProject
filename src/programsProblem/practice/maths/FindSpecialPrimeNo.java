package programsProblem.practice.maths;

import programsProblem.utils.DriverClass;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given with two integers N and D find all the N digit Prime Numbers having D as their most
 * frequent digit. E.g. if N=2 and D=3 so we have to find 2 digit integers having 3 as the most frequent
 * digit so answer will be [13,23,31,37,43,53,73,83] as these contain 3 as the most frequent digit.
 */
public class FindSpecialPrimeNo implements DriverClass<Integer> {
    @Override
    public void driverMethod(){
        int digits = 3, frequentNo = 5;

        printElement(getSpecialPrimeNo(digits, frequentNo));
    }

    private List<Integer> getSpecialPrimeNo(int digits, int frequentNo){
        List<Integer> resLst = new ArrayList<>();

        int range = 1;
        while (digits > 0){
            range = range * 10;
            digits--;
        }

        for(int num = range / 10;num < range - 1;num++){
            boolean isPrime = isPrimeNum(num);
            if(isPrime)
                if(String.valueOf(num).contains(String.valueOf(frequentNo)))
                    resLst.add(num);
        }

        return resLst;
    }

    private boolean isPrimeNum(int num){
        if(num == 1 && num == 2)
            return true;

        for(int i = 2;i <= Math.sqrt(num);i++)
            if(num % i == 0)
                return false;

        return true;
    }
}
