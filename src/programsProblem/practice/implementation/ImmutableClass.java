package programsProblem.practice.implementation;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {
    private final String name;

    private final int regNo;

    private final Map<String, String> metaData;

    public ImmutableClass(String name, int regNo, Map<String, String> metaData) {
        this.name = name;
        this.regNo = regNo;
        this.metaData = new HashMap<>(metaData);    //deep copying the map variable.
    }

    public String getName() {
        return this.name;
    }

    public int getRegNo() {
        return this.regNo;
    }

    public Map<String, String> getMetaData() {
        return new HashMap<>(this.metaData);
    }
}
