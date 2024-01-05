package programsProblem.practice.streamApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapMarksWithGrad {
    // Method to determine the grade based on the mark
    private static String getGrade(int mark) {
        if(mark >= 90) {
            return "A";
        } else if(mark >= 80) {
            return "B";
        } else if(mark >= 70) {
            return "C";
        } else if(mark >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void driverMethod() {
        List<Integer> marksList = Arrays.asList(85, 92, 78, 95, 88, 65, 70, 75);
        mapMarksWithGrad1(marksList);
    }

    //By me
    private void mapMarksWithGrad(List<Integer> markList) {
        Map<Integer, String> gradMap = new HashMap<>();
        markList.forEach(x -> {
            if(x >= 90) {
                gradMap.put(x, "A");
            } else if(x >= 70) {
                gradMap.put(x, "B");
            } else if(x >= 50) {
                gradMap.put(x, "C");
            } else {
                gradMap.put(x, "Fail");
            }
        });

        System.out.println(gradMap);
    }

    //Chat GPT
    private void mapMarksWithGrad1(List<Integer> marksList) {
        // Sample list of marks


        // Mapping grades using Java Stream API
        Map<Integer, String> gradesMap = marksList.stream()
                .collect(Collectors.toMap(
                        mark -> mark,
                        MapMarksWithGrad::getGrade
                ));

        // Print the resulting grades map
        System.out.println("Marks and Grades Map: " + gradesMap);
    }
}
