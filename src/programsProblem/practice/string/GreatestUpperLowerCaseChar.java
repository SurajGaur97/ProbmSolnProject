package programsProblem.practice.string;

import programsProblem.utils.DriverClass;

public class GreatestUpperLowerCaseChar implements DriverClass<String> {
    @Override
    public void driverMethod() {
//        String str = "lEeTcOdE";
        String str = "arRAzFif";
        printElement(greatestLetter(str));
    }

    public String greatestLetter(String s) {
        for (char c = 'Z';c >= 'A';c--)
            if(s.indexOf(c) != -1 && s.indexOf(Character.toLowerCase(c)) != -1)
                return String.valueOf(c);
        return "";
    }
}
