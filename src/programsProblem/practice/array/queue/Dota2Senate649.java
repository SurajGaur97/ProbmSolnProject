package programsProblem.practice.array.queue;

import programsProblem.utils.DriverClass;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 implements DriverClass<String> {
    @Override
    public void driverMethod() {
        String senate = "RDD";
        printElement(predictPartyVictory(senate));
    }

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQue = new LinkedList<>();
        Queue<Integer> dQue = new LinkedList<>();

        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R')
                rQue.add(i);
            else
                dQue.add(i);
        }

        while(!rQue.isEmpty() && !dQue.isEmpty()) {
            int rPeek = rQue.poll();
            int dPeek = dQue.poll();

            if(rPeek < dPeek)
                rQue.add(n + rPeek);
            else
                dQue.add(n + dPeek);
        }

        return rQue.isEmpty() ? "Dire" : "Radiant";
    }
}
