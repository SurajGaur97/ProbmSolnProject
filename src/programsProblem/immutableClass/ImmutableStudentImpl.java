package programsProblem.immutableClass;

import java.util.HashMap;
import java.util.Map;

public class ImmutableStudentImpl {

    private final String name;
    private final int regNo;
    private final Map<String, String> metaData;

    public ImmutableStudentImpl(String name, int regNo, Map<String, String> metaData) {
        this.name = name;
        this.regNo = regNo;

        //Creating temp map for cloning data of metadata into it.
        Map<String, String> tempMetaData = new HashMap<>();

        //Deep Copying:
        for (Map.Entry<String, String> entry : metaData.entrySet())
            tempMetaData.put(entry.getKey(), entry.getValue());
        this.metaData = tempMetaData;
    }

    public String getName() {return name;}
    public int getRegNo() {return regNo;}

    public Map<String, String> getMetaData() {
        Map<String, String> tempMetaData = new HashMap<>();
        for (Map.Entry<String, String> entry : this.metaData.entrySet())
            tempMetaData.put(entry.getKey(), entry.getValue());

        return tempMetaData;
    }
}

class mainClass {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("firstName", "John");
        map.put("lastName", "Smith");

        ImmutableStudentImpl ob = new ImmutableStudentImpl("Suraj", 24, map);

        //Calling getters methods
        System.out.println(ob.getName());
        System.out.println(ob.getRegNo());
        System.out.println(ob.getMetaData());

        //If we do this, there will be mo impact on the data.
        map.put("middleName", "Kumar");
        System.out.println(ob.getMetaData());

        //By below process the metaData will remain same due to Deep Copying the object.
        ob.getMetaData().put("parentName", "Gaur");
        System.out.println(ob.getMetaData());
    }
}
