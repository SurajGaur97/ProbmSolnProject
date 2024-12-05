package programsProblem.practice.string.twoPointer;

import programsProblem.utils.DriverClass;

public class ReverseVowelsOfString implements DriverClass<String> {
    @Override
    public void driverMethod() {
        printElement(reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        char[] a = s.toCharArray();

        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            if (isVowel(a[l]) && isVowel(a[r])) {
                swap(a, l++, r--);
            } else if (isVowel(a[l])) {
                r--;
            } else {
                l++;
            }
        }
        return new String(a);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);   //for not checking extra condition for Caps vowels.
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] cs, int start, int end) {
        char temp = cs[start];
        cs[start] = cs[end];
        cs[end] = temp;
    }
}
