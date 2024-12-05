package programsProblem.practice.array;

import programsProblem.utils.DriverClass;

public class CountRemovals implements DriverClass<Integer> {
    public static int countRemovals(String str) {
        int count = 0;
        int groupA = 0;
        int groupB = 0;

        // Iterate through the characters of the string
        for (char c : str.toCharArray()){
            if(c == 'A'){
                // Increment count for 'A'
                groupA++;
                // If 'B' group started before 'A', increment count
                count += groupB;
            } else if(c == 'B'){
                // If 'B' group starts, increment count for 'B'
                groupB++;
            }
        }

        // Return the total count of characters to be removed
        return count;
    }

    @Override
    public void driverMethod() {
        String input = "AABBAABB";
        int removals = countRemovals(input);
        System.out.println("Number of characters to remove: " + removals);
    }
}
