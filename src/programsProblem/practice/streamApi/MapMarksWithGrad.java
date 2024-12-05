package programsProblem.practice.streamApi;

import programsProblem.utils.DriverClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapMarksWithGrad implements DriverClass<Integer> {
    // Method to determine the grade based on the mark
    private static String getGrade(int mark){
        if(mark >= 90){
            return "A";
        } else if(mark >= 80){
            return "B";
        } else if(mark >= 70){
            return "C";
        } else if(mark >= 60){
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public void driverMethod(){
//        List<Integer> marksList = Arrays.asList(85, 92, 78, 95, 88, 65, 70, 75);
//        mapMarksWithGrad1(marksList);

        Map<String, Integer> studentMap = new HashMap<>();
        studentMap.put("Ram", 85);
        studentMap.put("Shyam", 92);
        studentMap.put("Mohan", 78);
        studentMap.put("Sohan", 95);
        studentMap.put("Suraj", 88);
        studentMap.put("Mahesh", 65);
        studentMap.put("Raj", 70);
        studentMap.put("Amit", 75);

        mapMarksWithGrad2(studentMap);
    }

    private void mapMarksWithGrad2(Map<String, Integer> studentMap){
        studentMap.forEach((key, value) -> System.out.println(key + ": " + getGrade(value)));
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

    //By me
    private void mapMarksWithGrad(List<Integer> markList){
        Map<Integer, String> gradMap = new HashMap<>();
        markList.forEach(x -> {
            if(x >= 90){
                gradMap.put(x, "A");
            } else if(x >= 70){
                gradMap.put(x, "B");
            } else if(x >= 50) {
                gradMap.put(x, "C");
            } else {
                gradMap.put(x, "Fail");
            }
        });

        System.out.println(gradMap);
    }
}
