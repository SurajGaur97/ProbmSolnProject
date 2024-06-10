package programsProblem.practice.string.slidingWindow;

import programsProblem.practice.common.DriverClass;

public class MaxVowels1456 implements DriverClass<Integer> {
    @Override
    public void driverMethod() {
        String str = "weallloveyou";
        int  k = 7;

        printElement(maxVowels(str, k));
    }

    public int maxVowels(String s, int k) {
        int maxVowel = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i)))
                maxVowel++;
        }

        int current = maxVowel;
        for(int i = 1; i + k <= s.length(); i++) {
            char subs = s.charAt(i - 1);
            char added = s.charAt(i + k - 1);

            if(!isVowel(subs) && isVowel(added)) current++;
            if(isVowel(subs) && !isVowel(added)) current--;

            maxVowel = Math.max(current, maxVowel);
        }

        return maxVowel;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
