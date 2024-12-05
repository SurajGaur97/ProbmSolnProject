package programsProblem.target75.string;

import programsProblem.utils.DriverClass;

public class RemoveSubString implements DriverClass<String> {
    @Override
    public void driverMethod(){
        String s = "ABEFCDGHEDCBEBA";     //res-> EFGHCEBE
        printElement(solve(s));
    }

    /**
     * @param s the provided String
     * @return String
     * @implNote remove subString: AB, BA, CD, DC from the string when it will come in it.
     */
    private String solve(String s){
        int j = 0;
        StringBuilder sb = new StringBuilder();

        while (j < s.length()){
            if((j < s.length() - 1)
                    && (((s.charAt(j) == 'A' && s.charAt(j + 1) == 'B')
                    || (s.charAt(j) == 'B' && s.charAt(j + 1) == 'A'))
                    || ((s.charAt(j) == 'C' && s.charAt(j + 1) == 'D')
                    || (s.charAt(j) == 'D' && s.charAt(j + 1) == 'C')))){
                j += 2;
                continue;
            } else {
                sb.append(s.charAt(j));
            }
            j++;
        }

        return sb.toString();
    }
}
